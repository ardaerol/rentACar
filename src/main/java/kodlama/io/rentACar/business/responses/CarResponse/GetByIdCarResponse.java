package kodlama.io.rentACar.business.responses.CarResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {
    private int carId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;
    private String modelName;
}
