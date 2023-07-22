package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String modelName){
        if (this.modelRepository.existsByModelName(modelName)){
            throw new BusinessException("Model alrady exists");
        }
    }

    public void chechIfModelIdExistsById(int modelId){
        if (this.modelRepository.existsByModelId(modelId)){

        }else{
            throw new BusinessException("This model Id is not exists");
        }
    }
}
