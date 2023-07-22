package kodlama.io.rentACar.business.responses.ModelResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponse {
    private int modelId;
    private String modelName;
    private String brandName;
}
