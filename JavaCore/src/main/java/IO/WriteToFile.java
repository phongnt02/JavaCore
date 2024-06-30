package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            // Tạo đối tượng PrintWriter để ghi dữ liệu vào file
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            Person person = new Person("John Doe", 30);

            // Dữ liệu cần ghi vào file
            String data = "Hello, World!\nExample Test 123.";

            // Ghi dữ liệu vào file
            writer.println(data);
            writer.println(person.toString());

            // Đóng PrintWriter sau khi hoàn thành
            writer.close();

            System.out.println("File writer success");
        } catch (IOException e) {
            System.out.println("Eror: " + e.getMessage());
        }
    }
}
