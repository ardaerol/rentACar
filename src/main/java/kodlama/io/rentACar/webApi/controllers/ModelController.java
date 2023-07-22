package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.ModelRequest.CreateModelRequest;
import kodlama.io.rentACar.business.requests.ModelRequest.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.ModelResponse.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addModel(@RequestBody @Valid CreateModelRequest createModelRequest){
        modelService.addModel(createModelRequest);
    }

    @PutMapping
    public void updateModel(@RequestBody UpdateModelRequest updateModelRequest){
        modelService.updateModel(updateModelRequest);
    }
}
