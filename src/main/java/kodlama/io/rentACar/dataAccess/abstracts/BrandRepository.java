package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByBrandName(String brandName); // spring jpa keywords
    boolean existsByBrandId(int brandId);
}
