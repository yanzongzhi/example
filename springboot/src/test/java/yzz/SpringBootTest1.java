package yzz;
import com.yzz.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
@WebAppConfiguration
public class SpringBootTest1 {
private RestTemplate restTemplate = new RestTemplate();



    @Test
    public void testShow() {
      Integer a =  restTemplate.getForObject("http://localhost:8180/test/test2",Integer.class);
      System.out.println(a);
    }
}
