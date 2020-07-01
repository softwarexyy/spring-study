import com.yancy.config.Config;
import com.yancy.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);  // 通过注解获取spring上下文容器

        IUserService userService = context.getBean("userServiceImpl", IUserService.class);
        String result = userService.getNameByCrdlsNo("18811363588");

        Logger logger = Logger.getLogger("YancyLogger");
        logger.info(result);
    }
}
