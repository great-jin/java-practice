import org.junit.Test;

import java.sql.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class JDBCTest {

    final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    final String JDBCURL = "jdbc:mysql://localhost:3306/budai_web_data?useSSL=true&useUnicode=true&characterEncoding=utf-8";
    final String USERNAME = "root";
    final String PASSWORD = "123456";
    final String SQL = "select * from user where id=?";

    @Test
    public void JDBCDemo() {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try ( Connection con = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
              PreparedStatement ps = con.prepareStatement(SQL); ) {
            ps.setString(1,"1");
            ResultSet result = ps.executeQuery();

            Map<String, Object> map = new LinkedHashMap<>();
            while(result.next()){
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    map.put(result.getMetaData().getColumnName(i), result.getString(i));
                }
            }
            System.out.println(map);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
