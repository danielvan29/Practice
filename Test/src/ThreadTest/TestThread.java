package ThreadTest;

public class TestThread {
    public static void main(String[] args) {
        /*RunnableDemo R1 = new RunnableDemo("DICK1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo("DICK2");
        R2.start();*/

        ThreadDemo T1 = new ThreadDemo("SUCK1");
        Thread thread = new Thread(T1);
        thread.start();
    }
}
