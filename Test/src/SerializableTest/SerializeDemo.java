package SerializableTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.name = "Van";
        e.address = "MeiZhou,China";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut = new FileOutputStream("src/tmp/employee.ser");//相对路径
            //FileOutputStream fileOut = new FileOutputStream("employee.ser");//如果只写文件名则放在项目文件夹下
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
