package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CarRequest.CreateCarRequest;
import kodlama.io.rentACar.business.requests.CarRequest.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.CarResponse.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.CarResponse.GetByIdCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> carsResponses = cars.stream().map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return carsResponses;

//        List<Model> models = modelRepository.findAll();
//
//        List<GetAllModelsResponse> modelResponse = models.stream()
//                .map(model -> this.modelMapperService.forResponse()
//                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
//        return modelResponse;
    }

    @Override
    public void addCar(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
        carRepository.save(car);
//        Model model = this.modelMapperService.forRequest()
//                .map(createModelRequest,Model.class);
//        modelRepository.save(model);
    }

    @Override
    public void deleteCar(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }

    @Override
    public void updateCar(UpdateCarRequest updateCarRequest) {

        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        carRepository.save(car);
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response = this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return response;
    }
}
