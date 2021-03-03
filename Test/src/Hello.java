import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.*;

public class Hello {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");
        //char A = 'a';
        //int B = A;
        //System.out.println(B);

        /*int a = 5;//定义一个变量；
        int b = 5;
        int x = 2*++a;
        int y = 2*b++;
        System.out.println("自增运算符前缀运算后a="+a+",x="+x);
        System.out.println("自增运算符后缀运算后b="+b+",y="+y);*/

        /*int x = 10;
        while( x < 20 ) {
            System.out.print("value of x : " + x++ );
            //++x;
            System.out.print("\n");
        }*/

        /*char c = 'c';
        String str;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            //c = (char) br.read();
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));*/

        File file = new File("E:\\text.txt");

        OutputStream outputStream = new FileOutputStream(file);

        byte bWrite[] = { 11, 21, 3, 40, 5 };
        /*for (int x = 0; x < bWrite.length; x++) {
            outputStream.write(bWrite[x]); // writes the bytes
        }*/
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.append("操");
        writer.append("\r\n");
        writer.append("fuck");
        writer.close();
        outputStream.close();

        InputStream inputStream = new FileInputStream(file);
        int size = inputStream.available();

        /*for (int i = 0; i < size; i++) {
            System.out.print((char) inputStream.read() + "  ");
        }*/

        InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()){
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        inputStream.close();
    }
}
