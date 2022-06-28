package database.diff.sql;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;
import database.diff.utils.DateUtils;
import database.diff.utils.TableInfo;

public class CountSQLTest {

    @Test
    public void Demo1() throws Exception {
        String schemaName = "data_platform_v3_1_police_single_datadevs15";
        String tableName = "integration_account_programme";
        String increaseFiled = "create_time";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(1, "mysql", tableInfo));
    }

    @Test
    public void Demo2() throws Exception {
        String schemaName = "ORACLE_ROOT";
        String tableName = "TB_TEST";
        String increaseFiled = "TIME1";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(1, "oracle", tableInfo));
    }

    @Test
    public void Demo3() throws Exception {
        String schemaName = "lyy_test";
        String tableName = "tb_user";
        String increaseFiled = "time1";
        TableInfo tableInfo = new TableInfo(schemaName, tableName, increaseFiled);

        System.out.println(CreateCountSQL(2, "hive", tableInfo));
    }

    public String CreateCountSQL(int frequency, String sourceType, TableInfo tableInfo) throws Exception {
        String schemaName = tableInfo.getSchemaName();
        String tableName = tableInfo.getTableName();
        String increaseFiled = tableInfo.getIncreaseFiled();

        String startDate = DateUtils.getProgrammeDate(frequency)[0];
        String endDate = DateUtils.getProgrammeDate(frequency)[1];

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT COUNT(*) FROM ");
        if (!StrUtil.isBlank(schemaName)) {
            builder.append(schemaName).append(".");
        }
        builder.append(tableName);

        switch (sourceType.toUpperCase()) {
            case "MYSQL":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" '").append(startDate).append("'")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" '").append(endDate).append("'");
                break;
            case "ORACLE":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" TO_DATE('").append(startDate).append("', 'YYYY-MM-DD')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" TO_DATE('").append(endDate).append("', 'YYYY-MM-DD');");
                break;
            case "HIVE":
                builder.append(" WHERE ").append(increaseFiled).append(" >")
                        .append(" unix_timestamp('").append(startDate).append("', 'yyyy-MM-dd')")
                        .append(" AND ").append(increaseFiled).append(" <")
                        .append(" unix_timestamp('").append(endDate).append("', 'yyyy-MM-dd')");
                break;
            default:
                throw new RuntimeException();
        }
        return builder.toString();
    }
}
