package database;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StructTest {

    final String JDBC = "jdbc:mysql://10.231.6.65:3306/test_db?useSSL=true&useUnicode=true&characterEncoding=utf-8";
    final String USERNAME = "root";
    final String PASSWORD = "123456";

    @Test
    public void SMDemo() {
        List<String> tableList = new ArrayList<>();
        List<String> typeList = new ArrayList<>();
        List<String> catList = new ArrayList<>();
        List<String> schemaList = new ArrayList<>();
        List<String> remarkList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC, USERNAME, PASSWORD)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                tableList.add(rs.getString("TABLE_NAME"));
                catList.add(rs.getString("TABLE_CAT"));
                // schemaList.add(rs.getString("TABLE_SCHEMA"));
                // remarkList.add(rs.getString("REMARKS"));
                // typeList.add(rs.getString("TABLE_TYPE"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("table list: ");
        System.out.println(tableList);
        System.out.println("database list: ");
        System.out.println(catList);

        // System.out.println(typeList);
        // System.out.println(schemaList);
        // System.out.println(remarkList);
    }
}
