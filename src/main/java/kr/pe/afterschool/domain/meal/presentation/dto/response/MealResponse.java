package kr.pe.afterschool.domain.meal.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MealResponse {

    private boolean exist;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String breakfast;
    private String lunch;
    private String dinner;
    private int calorie;
}
