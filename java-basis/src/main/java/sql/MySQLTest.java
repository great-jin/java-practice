package sql;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

public class MySQLTest {

    @Test
    public void Demo1() {
        System.out.println(CreateCountSQL());

        System.out.println(HourRecordSQL("id", "2022-06-08 17:00:00"));
    }

    /**
     * Count SQL 语句
     * <p>
     * SELECT DATE_FORMAT(<increase_filed>, '%Y-%m-%d %H:00:00') AS time, COUNT(*) AS num
     * FROM <table_name>
     * GROUP BY time
     * ORDER BY time;
     */
    public String CreateCountSQL() {
        String tableName = "integration_account_programme";
        String schemaName = "";
        String increaseFiled = "create_time";

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT DATE_FORMAT(").append(increaseFiled).append(", '%Y-%m-%d %H:00:00') AS time, COUNT(*) AS num");
        builder.append(" FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName).append(" GROUP BY time ORDER BY time;");
        return builder.toString();
    }

    /**
     * 获取 1 小时内的数据 SQL
     * <p>
     * select <filed> from <schema>.<table_name>
     * where <increase_filed> > '<specific_time>' and create_time < date_add('<specific_time>', interval + 60 MINUTE)
     */
    public String HourRecordSQL(String primaryKeyFiled, String dateScope) {
        String tableName = "integration_account_programme";
        String schemaName = "";
        String increaseFiled = "create_time";

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ").append(primaryKeyFiled).append(" FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName);
        builder.append(" WHERE ").append(increaseFiled).append(" > ").append("'").append(dateScope).append("'");
        builder.append(" AND ").append(increaseFiled).append(" < ");
        builder.append("DATE_ADD('").append(dateScope).append("', INTERVAL + 60 MINUTE);");
        return builder.toString();
    }
}
