package database.jdbc;

import cn.hutool.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OracleTest {

    final String CLASSNAME = "oracle.jdbc.OracleDriver";
    final String JDBC = "jdbc:oracle:thin:@10.231.6.65:1521:helowin";
    final String USERNAME = "root";
    final String PASSWORD = "123456";

    @Before
    public void Init() {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SMDemo() {
        final String SQL = "select * from TEST_0628";
        try (Connection con = DriverManager.getConnection(JDBC, USERNAME, PASSWORD)) {
            Map<String, Object> map = new LinkedHashMap<>();
            List<Map<String, Object>> list = new ArrayList<>();

            Statement stmt = con.createStatement();
            stmt.executeQuery(SQL);
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    map.put(result.getMetaData().getColumnName(i), result.getString(i));
                }
                list.add(new JSONObject(map));
            }
            System.out.println(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
