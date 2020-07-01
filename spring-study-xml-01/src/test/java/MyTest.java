import com.yancy.dao.HelloDao;
import com.yancy.pojo.Hello;
import com.yancy.service.HelloService;
import com.yancy.service.HelloServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello hello = (Hello) app.getBean("hello");
        System.out.println(hello);

        HelloService helloService = (HelloServiceImpl) app.getBean("helloService");
        helloService.sayHello();

        HelloDao helloDao = (HelloDao) app.getBean("helloyancy");
        System.out.println(helloDao);
    }
}
