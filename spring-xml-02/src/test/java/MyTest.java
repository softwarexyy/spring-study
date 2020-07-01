import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yancy.entity.Student;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) app.getBean("student");

        System.out.println(student);
    }
}
