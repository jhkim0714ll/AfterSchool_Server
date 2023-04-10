package kr.pe.afterschool.domain.meal.presentation.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NeisMealServiceDietInfoRowResponse {

    @SerializedName("ATPT_OFCDC_SC_CODE")
    private String ATPT_OFCDC_SC_CODE;
    @SerializedName("ATPT_OFCDC_SC_NM")
    private String ATPT_OFCDC_SC_NM;
    @SerializedName("SD_SCHUL_CODE")
    private String SD_SCHUL_CODE;
    @SerializedName("SCHUL_NM")
    private String SCHUL_NM;
    @SerializedName("MMEAL_SC_CODE")
    private String MMEAL_SC_CODE;
    @SerializedName("MMEAL_SC_NM")
    private String MMEAL_SC_NM;
    @SerializedName("MLSV_YMD")
    private String MLSV_YMD;
    @SerializedName("MLSV_FGR")
    private String MLSV_FGR;
    @SerializedName("DDISH_NM")
    private String DDISH_NM;
    @SerializedName("ORPLC_INF")
    private String ORPLC_INF;
    @SerializedName("CAL_INFO")
    private String CAL_INFO;
    @SerializedName("NTR_INFO")
    private String NTR_INFO;
    @SerializedName("MLSV_FROM_YMD")
    private String MLSV_FROM_YMD;
    @SerializedName("MLSV_TO_YMD")
    private String MLSV_TO_YMD;
}
