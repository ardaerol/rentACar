package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.BrandRequest.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.BrandRequest.UpdataBrandRequest;
import kodlama.io.rentACar.business.responses.BrandResponse.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.BrandResponse.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdataBrandRequest updataBrandRequest);
    void delete(int id);
}
