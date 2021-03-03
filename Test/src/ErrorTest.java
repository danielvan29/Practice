import java.rmi.RemoteException;

public class ErrorTest {
    public static void main(String[] args) {
        try{
            int[] a = new int[2];
            a[1] = 1;
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");
    }

    public void deposit(int amount) throws RemoteException
    {
        System.out.println(amount);
        // Method implementation
        throw new RemoteException();
    }
}

