package kodlama.io.rentACar.business.requests.BrandRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdataBrandRequest {
    private int brandId;
    private  String brandName;
}
