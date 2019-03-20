package c24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import c24.Bookstore.domain.User;
import c24.Bookstore.domain.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
    public void findByUserName() {
        User user = urepository.findByUsername("admin");
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("admin@hotmail.com");
    }
	
	@Test
    public void NewUser() {
    	User user = new User("kokeiluUser", "salasanakokeilu", "kokeilu@hotmail.com", "57865878756", "USER");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    	
    }
	
	@Test
    public void findByUsername() {
        User user = urepository.findByUsername("käyttäjä");
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("USER");
    }
	
	@Test
	public void DeleteUser() {
		User user = new User("kokeiluUser1", "salasanakokeilu2", "kokeilu@hotmail.com3", "57865878756", "USER");
		urepository.save(user);
		urepository.delete(user);
		assertThat(urepository.findById(user.getId())).isEmpty();
	}
	

}
