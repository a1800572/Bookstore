package c24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import c24.Bookstore.Controller.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestControllerSmoketest {
	
	@Autowired
	private RestController controller;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
