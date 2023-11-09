package top.tobycold.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tobycold.config.SpringConfig;
import top.tobycold.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    public void loginserviceTest(){
        boolean login = loginService.login(new User(1, "admin", "admin"));
        System.out.println(login);
    }
}
