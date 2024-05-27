package MyJDBC;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExampleModel extends BaseModel {
    public ExampleModel() throws SQLException {
        super();
    }

    public void createExampleTable() throws SQLException {
        Map<String, String> columnDefinitions = new HashMap<>();
        columnDefinitions.put("id", "INT AUTO_INCREMENT PRIMARY KEY");
        columnDefinitions.put("name", "VARCHAR(255)");
        columnDefinitions.put("age", "INT");
        this.createTable("example_table", columnDefinitions);

        // Add foreign key constraint
//        addForeignKeyConstraint("example_table", "foreign_key_column", "related_table", "related_column");
    }

}
