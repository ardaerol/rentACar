package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CarRequest.CreateCarRequest;
import kodlama.io.rentACar.business.requests.CarRequest.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.CarResponse.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.CarResponse.GetByIdCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotation
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarControllers {
    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){
        return carService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCar(@RequestBody @Valid CreateCarRequest createCarRequest){
        carService.addCar(createCarRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id){
        carService.deleteCar(id);
    }

    @PutMapping()
    public void updateCar(UpdateCarRequest updateCarRequest){
        carService.updateCar(updateCarRequest);
    }

    @GetMapping("/{id}")
    public GetByIdCarResponse getById(int id){
      return   carService.getById(id);
    }
}

