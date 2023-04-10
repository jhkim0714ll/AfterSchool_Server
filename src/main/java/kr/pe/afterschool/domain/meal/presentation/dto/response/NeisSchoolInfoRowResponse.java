package kr.pe.afterschool.domain.meal.presentation.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NeisSchoolInfoRowResponse {

    @SerializedName("ATPT_OFCDC_SC_CODE")
    private String ATPT_OFCDC_SC_CODE;
    @SerializedName("ATPT_OFCDC_SC_NM")
    private String ATPT_OFCDC_SC_NM;
    @SerializedName("SD_SCHUL_CODE")
    private String SD_SCHUL_CODE;
    @SerializedName("SCHUL_NM")
    private String SCHUL_NM;
    @SerializedName("ENG_SCHUL_NM")
    private String ENG_SCHUL_NM;
    @SerializedName("SCHUL_KND_SC_NM")
    private String SCHUL_KND_SC_NM;
    @SerializedName("LCTN_SC_NM")
    private String LCTN_SC_NM;
    @SerializedName("JU_ORG_NM")
    private String JU_ORG_NM;
    @SerializedName("FOND_SC_NM")
    private String FOND_SC_NM;
    @SerializedName("ORG_RDNZC")
    private String ORG_RDNZC;
    @SerializedName("ORG_RDNMA")
    private String ORG_RDNMA;
    @SerializedName("ORG_RDNDA")
    private String ORG_RDNDA;
    @SerializedName("ORG_TELNO")
    private String ORG_TELNO;
    @SerializedName("HMPG_ADRES")
    private String HMPG_ADRES;
    @SerializedName("COEDU_SC_NM")
    private String COEDU_SC_NM;
    @SerializedName("ORG_FAXNO")
    private String ORG_FAXNO;
    @SerializedName("HS_SC_NM")
    private String HS_SC_NM;
    @SerializedName("INDST_SPECL_CCCCL_EXST_YN")
    private String INDST_SPECL_CCCCL_EXST_YN;
    @SerializedName("HS_GNRL_BUSNS_SC_NM")
    private String HS_GNRL_BUSNS_SC_NM;
    @SerializedName("SPCLY_PURPS_HS_ORD_NM")
    private String SPCLY_PURPS_HS_ORD_NM;
    @SerializedName("ENE_BFE_SEHF_SC_NM")
    private String ENE_BFE_SEHF_SC_NM;
    @SerializedName("DGHT_SC_NM")
    private String DGHT_SC_NM;
    @SerializedName("FOND_YMD")
    private String FOND_YMD;
    @SerializedName("FOAS_MEMRD")
    private String FOAS_MEMRD;
    @SerializedName("LOAD_DTM")
    private String LOAD_DTM;
}
