package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.ModelRequest.CreateModelRequest;
import kodlama.io.rentACar.business.requests.ModelRequest.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.ModelResponse.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.ModelResponse.GetByIdModelResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelResponse;
    }

    @Override
    public void addModel(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getModelName());
        Model model = this.modelMapperService.forRequest()
                .map(createModelRequest,Model.class);
        modelRepository.save(model);
    }

    @Override
    public void updateModel(UpdateModelRequest updateModelRequest ) {

        Model model = this.modelMapperService.forRequest()
                .map(updateModelRequest,Model.class);

        modelRepository.save(model);
    }

    @Override
    public void deleteModel(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(model);
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        this.modelBusinessRules.chechIfModelIdExistsById(id);
        Model model = modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse getByIdModelResponse = this.modelMapperService.forResponse()
                .map(model,GetByIdModelResponse.class);

        return getByIdModelResponse;
    }
}
