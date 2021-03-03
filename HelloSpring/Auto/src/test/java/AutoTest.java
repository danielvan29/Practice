import com.van.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoTest {
    @Test
    public void autoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getCat());
    }
}
