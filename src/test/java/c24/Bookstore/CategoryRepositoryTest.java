package c24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import c24.Bookstore.domain.Category;
import c24.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
    public void findByName() {
        List<Category> category = crepository.findByName("Cooking");
        assertThat(category).hasSize(1);
        assertThat(category.get(0).getCategoryid()).isEqualTo(7);
    }
	
	
	@Test
    public void NewCategory() {
    	Category category = new Category("Testi");
    	crepository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    	
    }
	
	@Test
	public void DeleteCategory() {
		Category category = new Category("kokeilu");
		crepository.save(category);
		crepository.delete(category);
		assertThat(crepository.findById(category.getCategoryid())).isEmpty();
	}

}
