package biztechi.aic.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDto {

    @NotBlank
    @Length(min = 10, max = 250)
    private String title;

    @NotBlank
    @Length(min = 10, max = 250)
    private String content;

    @NotBlank
    @Length(max = 250)
    private String categoryCode;
}
