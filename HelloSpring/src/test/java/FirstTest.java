import com.van.pojo.Hello;
import com.van.pojo.Person;
import com.van.pojo.Student;
import com.van.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Set;

public class FirstTest {
    public static void main(String[] args) {
        //获取spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        //System.out.println(hello.getName());
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    @Test
    public void injectionTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getAddress());
        Map<String, String>[] cards = student.getCard();
        for (Map<String, String> card : cards) {
            System.out.println(card.entrySet());
        }
        Set<String>[] games = student.getGames();
        for (Set<String> game : games) {
            System.out.print(game.toString());
        }
    }

    @Test
    public void scopeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        User user1 = context.getBean("user", User.class);
        System.out.println(user == user1);
    }
}
