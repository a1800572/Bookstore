package c24.Bookstore;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void List() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("booklist")));
    }
    
    
    @Test
    public void New() throws Exception {
        this.mockMvc.perform(get("/newbook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("book")));
    }
    
    @Test
    public void Login() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("login")));
    }
    
    
    
    
}