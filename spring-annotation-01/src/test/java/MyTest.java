import com.yancy.config.Config;
import com.yancy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);  // 通过注解获取spring上下文容器

        // 获取bean对象
        IUserService userService = context.getBean("userServiceImpl", IUserService.class);
//        IUserService userService = (IUserService) context.getBean("userServiceImpl");
        String result = userService.getNameByCrdlsNo("18811363588");

//        Logger logger = Logger.getLogger("YancyLogger");
        log.info(result);
    }
}
