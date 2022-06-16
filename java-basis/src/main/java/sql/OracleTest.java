package sql;

import cn.hutool.core.util.StrUtil;

public class OracleTest {
    public static void main(String[] args) {
        System.out.println(CreateCountSQL());

        System.out.println(CreateHourRecordSQL("ID", "2022-06-16 16"));
    }

    public static String CreateCountSQL() {
        String tableName = "TB_TEST";
        String schemaName = "";
        String increaseFiled = "TIME1";

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT TO_CHAR(").append(increaseFiled);
        builder.append(", 'yyyy-mm-dd hh24') AS TIME_SCOPE, COUNT(*) AS MINUTE_TOTAL FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName).append(" GROUP BY TO_CHAR(").append(increaseFiled);
        builder.append(", 'yyyy-mm-dd hh24') ORDER BY TIME_SCOPE;");
        return builder.toString();
    }

    /**
     * 获取 1 小时内的数据 SQL
     * <p>
     * select <filed> from <schema>.<table_name>
     * where <increase_filed> > '<specific_time>' and create_time < date_add('<specific_time>', interval + 60 MINUTE)
     */
    public static String CreateHourRecordSQL(String primaryKeyFiled, String dateScope) {
        String tableName = "TB_TEST";
        String schemaName = "";
        String increaseFiled = "TIME1";

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ").append(primaryKeyFiled).append(" FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName);
        builder.append(" WHERE ").append(increaseFiled).append(" > ").append("TO_DATE('");
        builder.append(dateScope).append("', 'yyyy-mm-dd hh24') ");
        builder.append("AND ").append(increaseFiled).append(" < ").append("TO_DATE('");
        builder.append(dateScope).append("', 'yyyy-mm-dd hh24')+1/24;");
        return builder.toString();
    }
}
