package action;

public class Animal {
    private int n;
    int a;

    public Animal() {
        System.out.println("null");
    }

    public Animal(int n) {
        System.out.println(n);
        this.n = n;
    }

    public void move(){
        System.out.println("动物可以移动");
    }

    public void eat() {
        System.out.println("吃");
    }
}
