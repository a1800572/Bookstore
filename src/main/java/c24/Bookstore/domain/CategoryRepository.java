package c24.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	//http://localhost:8080/api/categories/search/findByName?name=Horror
	List<Category> findByName(@Param("name") String name);

}
