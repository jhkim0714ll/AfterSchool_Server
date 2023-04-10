package kr.pe.afterschool.domain.meal.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MealResponse {

    private boolean exist;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String breakfast;
    private String lunch;
    private String dinner;
    private int calorie;
}
