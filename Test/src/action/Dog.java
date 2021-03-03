package action;

public class Dog extends Animal {

    Dog(int n) {
        super(n);
    }

    public void move(){
        System.out.println("狗可以跑和走");
    }

    public void eat() {
        System.out.println("吃骨头");
    }
    public void work() {
        System.out.println("看家");
    }
}
