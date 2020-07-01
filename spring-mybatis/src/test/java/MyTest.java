import com.yancy.dao.UserMapper;
import com.yancy.dao2.UserMapper2;
import com.yancy.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /**
     * 方式一: 通过Mapper实现类MapperImpl注册到Spring中，获取 mapper
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }

    /**
     * 方式二： 通过MapperScan自动配置mapper
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper2 userMapper2 = context.getBean("userMapper2", UserMapper2.class);
        for (User user : userMapper2.selectUser2()) {
            System.out.println(user);
        }
    }
}
