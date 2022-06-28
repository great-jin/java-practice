package database;

import cn.hutool.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultTest {

    final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    final String JDBC = "jdbc:mysql://10.231.6.65:3306/test_db?useSSL=true&useUnicode=true&characterEncoding=utf-8";
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
    public void SMDemo() {
        List<String[]> list = new ArrayList<>();
        final String SQL = "select DATE_FORMAT(update_time, '%Y-%m-%d %H:00:00') as time, COUNT(*) as num from test_db.user_info where update_time > '2022-06-18' and update_time < '2022-06-23' group by time order by time;";

        try (Connection con = DriverManager.getConnection(JDBC, USERNAME, PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                String[] r = new String[2];
                for (int i = 1; i <= 2; i++) {
                    r[i - 1] = result.getString(i);
                }
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list.get(0)[0]);
        System.out.println(list.get(0)[1]);
    }
}
