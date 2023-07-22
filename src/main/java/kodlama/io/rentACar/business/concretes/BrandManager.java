package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.BrandRequest.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.BrandRequest.UpdataBrandRequest;
import kodlama.io.rentACar.business.responses.BrandResponse.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.BrandResponse.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // bu sdınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
          List<Brand> brands = brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
//
//        for (Brand brand:brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setBrandId(brand.getBrandId());
//            responseItem.setBrandName(brand.getBrandName());
//            brandsResponses.add(responseItem);
//        }

        List<GetAllBrandsResponse> brandsResponses =
                brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        this.brandBusinessRules.chechIfBrandIdExistsById(id);
       Brand brand = this.brandRepository.findById(id).orElseThrow();

       GetByIdBrandResponse response = this.modelMapperService.forResponse()
               .map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getBrandName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdataBrandRequest updataBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updataBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);
    }
}
