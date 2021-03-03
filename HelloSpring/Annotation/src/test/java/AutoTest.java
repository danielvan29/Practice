import com.van.pojo.Person;
import com.van.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoTest {
    @Test
    public void autoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getCat());
        System.out.println(person.getDog());
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
    }
}
