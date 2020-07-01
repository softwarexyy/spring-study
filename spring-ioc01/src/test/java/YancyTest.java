import com.yancy.dao.HelloDaoAliceImpl;
import com.yancy.dao.HelloDaoImpl;
import com.yancy.dao.HelloDaoYancyImpl;
import com.yancy.service.HelloService;
import com.yancy.service.HelloServiceImpl;

public class YancyTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();

        // 以下三个实现，调用方选择不同的dao层实现类，控制service对象的创建

        ((HelloServiceImpl) helloService).setHelloDao(new HelloDaoImpl());
        helloService.sayHello();

        ((HelloServiceImpl) helloService).setHelloDao(new HelloDaoYancyImpl());
        helloService.sayHello();

        ((HelloServiceImpl) helloService).setHelloDao(new HelloDaoAliceImpl());
        helloService.sayHello();
    }
}
