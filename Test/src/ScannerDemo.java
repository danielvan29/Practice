import java.rmi.RemoteException;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        double sum = 0;
        int m = 0;

        while (scan.hasNextDouble()) {
            System.out.println("a");
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();*/

        ErrorTest errorTest = new ErrorTest();
        try {
            errorTest.deposit(1);
        } catch (RemoteException e) {
            //e.printStackTrace();
            System.out.println(e);
        } finally {
            System.gc();
        }
    }
}
