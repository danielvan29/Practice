package action;

import myCollection.CloneDemo;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo demo = new CloneDemo();
        demo.age = 20;
        demo.name = "van";
        demo.hello();

    }
}
