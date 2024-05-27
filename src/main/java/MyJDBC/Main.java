package MyJDBC;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ExampleModel exampleModel = new ExampleModel();
            exampleModel.createExampleTable();
            System.out.println("Table created successfully!");

            // insert data
//            Map<String, Object> columnValues = new HashMap<>();
//            columnValues.put("name", "John");
//            columnValues.put("age", 30);
//
//            exampleModel.insert(columnValues);

            // update data
            Map<String, Object> fields = new HashMap<>();
            fields.put("name", "Doe");
            fields.put("age", 29);
            String condition = "id = 17";
            exampleModel.update(fields, condition);


            // selectAll
            System.out.println("select all:");
            List<Map<String, Object>> records = exampleModel.selectAll();
            records.forEach(row-> System.out.println(row));

            // delete data
            String condi = "id = 2";
            exampleModel.delete(condi);

            // DB raw
            System.out.println("DBRaw:");
            String queryAll = "SELECT * FROM example_table ORDER BY id DESC";
            List<Map<String, Object>> record = exampleModel.DBRaw(queryAll);
//            record.forEach(row -> System.out.println(row));
            record.forEach(System.out::println);

            String query = "SELECT * FROM example_table WHERE id = ?";
            List<Map<String, Object>> recordId = exampleModel.DBRaw(query, 1);
            if(recordId.isEmpty()) {
                System.out.println("Khong co data");
            }
            recordId.forEach(row -> System.out.println(row));

            // call procedure
//            exampleModel.callProcedure("my_procedure", "param1_value", "param2_value");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
