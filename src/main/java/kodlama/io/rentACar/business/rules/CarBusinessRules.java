package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private CarRepository carRepository;

    public void checkIfPlateExists(String plate){
        if (this.carRepository.existsByPlate(plate)){
            throw new BusinessException("This plate already in exists");
        }
    }

    public void checkIfCarIdExistsById(int carId){
        if (carRepository.existsByCarId(carId)){

        }else {
            throw new BusinessException("This car is not exists");
        }

    }
}
