package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CarRequest.CreateCarRequest;
import kodlama.io.rentACar.business.requests.CarRequest.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.CarResponse.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.CarResponse.GetByIdCarResponse;
import kodlama.io.rentACar.business.responses.ModelResponse.GetAllModelsResponse;
import kodlama.io.rentACar.entities.concretes.Car;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    void addCar(CreateCarRequest createCarRequest);
    void deleteCar(int id);
    void updateCar(UpdateCarRequest updateCarRequest);
    GetByIdCarResponse getById(int id);
}
