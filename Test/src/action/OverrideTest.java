package action;

public class OverrideTest {

    public static void main(String[] args) {
        Animal dog = new Dog(3);
        dog.move();
        System.out.println(dog.a);

        Animal a = new Cat();  // 向上转型
        a.eat();              // 调用的是 Cat 的 eat
        Cat c = (Cat)a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work
    }

    public static void show(Animal a)  {
        a.move();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }
}
