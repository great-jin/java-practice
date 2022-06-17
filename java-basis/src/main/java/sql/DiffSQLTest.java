package sql;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;
import sql.utils.DateUtils;
import sql.utils.TableInfo;

public class DiffSQLTest {

    @Test
    public void Demo1() throws Exception {
        String schemaName = "data_platform_v3_1_police_single_datadevs15";
        String tableName = "integration_account_programme";
        String increaseFiled = "create_time";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(2, "mysql", tableInfo) + "\n");
        System.out.println(CreateHourRecordSQL(tableInfo, "mysql", "id", "2022-06-08 17:00:00"));
    }

    @Test
    public void Demo2() throws Exception {
        String schemaName = "ORACLE_ROOT";
        String tableName = "TB_TEST";
        String increaseFiled = "TIME1";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(2, "oracle", tableInfo) + "\n");
        System.out.println(CreateHourRecordSQL(tableInfo, "oracle", "id", "2022-06-15 10"));
    }

    @Test
    public void Demo3() throws Exception {
        String schemaName = "lyy_test";
        String tableName = "tb_user";
        String increaseFiled = "time1";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(2, "hive", tableInfo) + "\n");
        System.out.println(CreateHourRecordSQL(tableInfo, "hive", "id", "2022-06-16 16:00:00"));
    }

    /**
     * Count SQL 语句
     */
    public String CreateCountSQL(int frequency, String sourceType, TableInfo tableInfo) throws Exception {
        String schemaName = tableInfo.getSchemaName();
        String tableName = tableInfo.getTableName();
        String increaseFiled = tableInfo.getIncreaseFiled();

        StringBuilder builder = new StringBuilder();
        String startDate = DateUtils.getProgrammeDate(frequency)[0];
        String endDate = DateUtils.getProgrammeDate(frequency)[1];
        switch (sourceType.toUpperCase()) {
            case "MYSQL":
                builder.append("SELECT DATE_FORMAT(").append(increaseFiled)
                        .append(", '%Y-%m-%d %H:00:00') AS time, COUNT(*) AS num FROM ");
                if (!StrUtil.isBlank(schemaName)) {
                    builder.append(schemaName).append(".");
                }
                builder.append(tableName)
                        .append(" WHERE ").append(increaseFiled).append(" > '").append(startDate).append("'")
                        .append(" AND ").append(increaseFiled).append(" < '").append(endDate).append("'")
                        .append(" GROUP BY time ORDER BY time;");
                break;
            case "ORACLE":
                builder.append("SELECT TO_CHAR(").append(increaseFiled);
                builder.append(", 'yyyy-MM-dd hh24') AS TIME_SCOPE, COUNT(*) AS MINUTE_TOTAL FROM ");
                if (!StrUtil.isBlank(schemaName)) {
                    builder.append(schemaName).append(".");
                }
                builder.append(tableName)
                        .append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" TO_DATE('").append(startDate).append("', 'yyyy-MM-dd')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" TO_DATE('").append(endDate).append("', 'yyyy-MM-dd')")
                        .append(" GROUP BY TO_CHAR(").append(increaseFiled)
                        .append(", 'yyyy-MM-dd hh24') ORDER BY TIME_SCOPE;");
                break;
            case "HIVE":
                builder.append("SELECT from_unixtime(unix_timestamp(").append(increaseFiled)
                        .append("),'yyyy-MM-dd HH:00:00') AS time2, COUNT(*) AS num FROM ");
                if (!StrUtil.isBlank(schemaName)) {
                    builder.append(schemaName).append(".");
                }
                builder.append(tableName)
                        .append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" unix_timestamp('").append(startDate).append("', 'yyyy-MM-dd')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" unix_timestamp('").append(endDate).append("', 'yyyy-MM-dd')")
                        .append(" GROUP BY from_unixtime(unix_timestamp(").append(increaseFiled)
                        .append("), 'yyyy-MM-dd HH:00:00') ORDER BY time2;");
                break;
            default:
                throw new RuntimeException();
        }
        return builder.toString();
    }

    /**
     * 获取 1 小时内的数据 SQL
     */
    public String CreateHourRecordSQL(TableInfo tableInfo, String sourceType, String keyFiled, String dateScope) {
        String schemaName = tableInfo.getSchemaName();
        String tableName = tableInfo.getTableName();
        String increaseFiled = tableInfo.getIncreaseFiled();

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ").append(keyFiled).append(" FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName);

        switch (sourceType.toUpperCase()) {
            case "MYSQL":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" '").append(dateScope).append("'")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" DATE_ADD('").append(dateScope).append("', INTERVAL + 60 MINUTE);");
                break;
            case "ORACLE":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" TO_DATE('").append(dateScope).append("', 'yyyy-mm-dd hh24')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" TO_DATE('").append(dateScope).append("', 'yyyy-mm-dd hh24')+1/24;");
                break;
            case "HIVE":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" unix_timestamp('").append(dateScope).append("', 'yyyy-MM-dd HH:00:00')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" unix_timestamp('").append(dateScope).append("', 'yyyy-MM-dd HH:00:00')+3600");
                break;
            default:
                throw new RuntimeException("暂不支持 \"" + sourceType + "\" 类型数据库。");
        }
        return builder.toString();
    }
}
