package pl.lodz.p.carpooling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.lodz.p.carpooling.security.WebSecurityInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CarpoolingApplication.class, WebSecurityInitializer.class})
@WebAppConfiguration
public class CarpoolingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
