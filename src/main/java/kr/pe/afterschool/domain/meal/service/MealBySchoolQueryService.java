package kr.pe.afterschool.domain.meal.service;

import com.google.gson.Gson;
import kr.pe.afterschool.domain.meal.presentation.dto.response.MealResponse;
import kr.pe.afterschool.domain.meal.presentation.dto.response.NeisMealServiceDietInfoRowResponse;
import kr.pe.afterschool.domain.meal.presentation.dto.response.NeisSchoolInfoRowResponse;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.global.config.properties.NeisProperties;
import kr.pe.afterschool.global.lib.DateParser;
import kr.pe.afterschool.global.lib.JsonParser;
import kr.pe.afterschool.global.lib.StringParser;
import kr.pe.afterschool.thirdparth.feign.client.NeisMealInfo;
import kr.pe.afterschool.thirdparth.feign.client.NeisSchoolInfo;
import kr.pe.afterschool.thirdparth.feign.exception.OtherServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealBySchoolQueryService {

    private final NeisSchoolInfo neisSchoolInfo;
    private final NeisMealInfo neisMealInfo;
    private final SchoolRepository schoolRepository;
    private final NeisProperties neisProperties;
    private final DateParser dateParser;
    private final StringParser stringParser;
    private final JsonParser jsonParser;

    @Transactional(readOnly = true)
    public List<MealResponse> execute(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);

        LocalDate now = LocalDate.now();
        String yearStr = String.format("%04d", now.getYear());
        String monthStr = String.format("%02d", now.getMonthValue());

        String schoolInfo = neisSchoolInfo.getSchoolInfo(
                neisProperties.getApiKey(),
                "json",
                1,
                10,
                school.getName()
        );

        try {
            JSONArray schoolRow = jsonParser.StringToJSONArrayOfRow(schoolInfo, "schoolInfo");

            NeisSchoolInfoRowResponse schoolResponse;
            JSONArray mealRow = new JSONArray();
            for (int i = 0; i < schoolRow.length(); i++) {
                schoolResponse = new Gson().fromJson(schoolRow.get(i).toString(), NeisSchoolInfoRowResponse.class);

                if (school.getName().equals(schoolResponse.getSCHUL_NM()) && school.getEducationOffice().equals(schoolResponse.getATPT_OFCDC_SC_NM())) {
                    String mealInfo = neisMealInfo.getMealInfo(
                            neisProperties.getApiKey(),
                            "json",
                            1,
                            100,
                            schoolResponse.getATPT_OFCDC_SC_CODE(),
                            schoolResponse.getSD_SCHUL_CODE(),
                            yearStr + monthStr);
                    if (mealInfo.contains("INFO-200")) {
                        return new ArrayList<>();
                    }

                    mealRow = jsonParser.StringToJSONArrayOfRow(mealInfo, "mealServiceDietInfo");
                }
            }

            List<NeisMealServiceDietInfoRowResponse> mealList = new ArrayList<>();
            for (int i = 0; i < mealRow.length(); i++ ) {
                mealList.add(new Gson().fromJson(mealRow.get(i).toString(), NeisMealServiceDietInfoRowResponse.class));
            }

            List<MealResponse> mealResponse = new ArrayList<>();

            YearMonth month = YearMonth.from(now);
            LocalDate lastDate = month.atEndOfMonth();

            for (int i = 0; i < lastDate.getDayOfMonth(); i++) {
                String dayStr = String.format("%02d", i + 1);
                MealResponse meal = MealResponse.builder()
                        .date(dateParser.parseStringToDate(yearStr, monthStr, dayStr))
                        .exist(false)
                        .breakfast("")
                        .lunch("")
                        .dinner("")
                        .build();

                for (NeisMealServiceDietInfoRowResponse mealInfo : mealList) {
                    if (mealInfo.getMLSV_YMD().equals(yearStr + monthStr + dayStr)) {
                        meal.setExist(true);
                        switch (mealInfo.getMMEAL_SC_NM()) {
                            case "조식":
                                meal.setBreakfast(stringParser.mealConvert(mealInfo.getDDISH_NM()));
                                break;
                            case "중식":
                                meal.setLunch(stringParser.mealConvert(mealInfo.getDDISH_NM()));
                                break;
                            case "석식":
                                meal.setDinner(stringParser.mealConvert(mealInfo.getDDISH_NM()));
                                break;
                        }
                    }
                }
                mealResponse.add(meal);
            }
            return mealResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw OtherServerErrorException.EXCEPTION;
        }
    }
}
