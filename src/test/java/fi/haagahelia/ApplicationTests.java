package fi.haagahelia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fi.haagahelia.controllers.PalauteController;
import fi.haagahelia.models.Kysymys;
import fi.haagahelia.repositories.KysymysRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
    private WebApplicationContext context;

    private MockMvc mockmvc;
    
    @Autowired
    private KysymysRepository kysrepo;

    @Before
    public void setup() {
        this.mockmvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
	
    @Test
    public void testIndex() throws Exception {
	this.mockmvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
	
    @Test
    public void lisaaKysymys() {
		Kysymys k = new Kysymys();
		k.setId(44);
		k.setKyselyid(3);
		k.setNimi("Testikysymys?");
		k.setTyyppiId(3);
		k.setVastausvaihtoehdot("1,2,3");
		
		kysrepo.save(k);
		assertNotNull(k); 
    }

}
