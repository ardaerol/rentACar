package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.ModelRequest.CreateModelRequest;
import kodlama.io.rentACar.business.requests.ModelRequest.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.ModelResponse.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.ModelResponse.GetByIdModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void  addModel(CreateModelRequest createModelRequest);

    void updateModel(UpdateModelRequest updateModelRequest);
    void deleteModel(int id);
    GetByIdModelResponse getById(int id);
}
