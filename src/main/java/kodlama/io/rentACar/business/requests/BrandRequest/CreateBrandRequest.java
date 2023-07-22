package kodlama.io.rentACar.business.requests.BrandRequest;

import jakarta.validation.constraints.NotBlank; //Araştır
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {

    @NotNull
    @NotBlank
    @Size(min = 2,max = 12)
    private String brandName;
}
