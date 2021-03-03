package myEnum;

import java.util.EnumMap;

public class DBTest {

    private EnumMap<DataBaseType,String>urls=new EnumMap<DataBaseType,String>(DataBaseType.class);

    public void DataBaseInfo()
    {
        urls.put(DataBaseType.DB2,"jdbc:db2://localhost:5000/sample");
        urls.put(DataBaseType.MYSQL,"jdbc:mysql://localhost/mydb");
        urls.put(DataBaseType.ORACLE,"jdbc:oracle:thin:@localhost:1521:sample");
        urls.put(DataBaseType.SQLSERVER,"jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    }


    public String getURL(DataBaseType type)
    {
        return this.urls.get(type);
    }

    public static void main(String[] args) {

    }

}
