package database.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class MySQLTest {

    final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    final String JDBC = "jdbc:mysql://localhost:3306/budai_web_data?useSSL=true&useUnicode=true&characterEncoding=utf-8";
    final String USERNAME = "root";
    final String PASSWORD = "123456";

    private Map<String, Object> map = new LinkedHashMap<>();
    private List<Map<String, Object>> list = new ArrayList<>();

    @Before
    public void Init() {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void QueryDemo() {
        final String SQL = "select * from user_info";
        try (Connection con = DriverManager.getConnection(JDBC, USERNAME, PASSWORD)) {
            Statement stmt = con.createStatement();
            stmt.executeQuery(SQL);
            ResultSet result = stmt.getResultSet();

            while (result.next()) {
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    map.put(result.getMetaData().getColumnName(i), result.getString(i));
                }
                list.add(map);
            }
            System.out.println(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void PrepareDemo() {
        final String SQL = "select * from user_info where id=?";
        try (Connection con = DriverManager.getConnection(JDBC, USERNAME, PASSWORD);
             PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, "4");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    map.put(result.getMetaData().getColumnName(i), result.getString(i));
                }
                list.add(map);
            }
            System.out.println(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
