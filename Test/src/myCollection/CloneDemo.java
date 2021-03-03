package myCollection;

public class CloneDemo implements Cloneable{
    public String name;
    public int age;

    public void hello(){
        System.out.println();
    }

    public static void main(String[] args) {
        CloneDemo demo = new CloneDemo();
        demo.age = 20;
        demo.name = "van";
        try {
            CloneDemo demo1 = (CloneDemo) demo.clone();
            System.out.println(demo1.age + " " + demo1.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
