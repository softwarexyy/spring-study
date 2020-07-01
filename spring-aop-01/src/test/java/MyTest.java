import com.yancy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 此处需要注意：动态代理 是针对接口的，所以这个对象要把类型设置成接口
        UserService userService = context.getBean("userService", UserService.class);

        userService.add("hello", "yancy");
//        userService.delete();
    }
}
