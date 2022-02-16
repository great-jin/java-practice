import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        String className = "com.mysql.jdbc.Driver";
        String JDBCURL = "jdbc:mysql://localhost:3306/demo?useSSL=true&useUnicode=true&characterEncoding=utf-8";
        String UserName = "root";
        String PassWord = "123456";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(className);
            con=DriverManager.getConnection(JDBCURL,UserName,PassWord);

            String loginid = "1";
            String loginname = "aa";

            String sql="select * from user where id=? and name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, loginid);
            ps.setString(2, loginname);
            rs = ps.executeQuery();

            if(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");

                if(id.equals(loginid) && name.equals(loginname)) {
                    // TODO 登录成功
                }else {
                    // TODO 账号密码错误
                }
            }else {
                // TODO 登录失败
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭资源
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
