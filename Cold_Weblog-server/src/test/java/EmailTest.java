import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tobycold.config.SpringConfig;
import top.tobycold.util.EmailUtil;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EmailTest {
    @Test
    public void testEmail() throws MessagingException, UnsupportedEncodingException {
        EmailUtil.sendEmail();
    }
}
