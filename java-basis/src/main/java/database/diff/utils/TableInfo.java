package database.diff.utils;

public class TableInfo {

    private String tableName;

    private String schemaName;

    private String increaseFiled;

    public TableInfo(String schemaName, String tableName, String increaseFiled) {
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.increaseFiled = increaseFiled;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getIncreaseFiled() {
        return increaseFiled;
    }

    public void setIncreaseFiled(String increaseFiled) {
        this.increaseFiled = increaseFiled;
    }
}
