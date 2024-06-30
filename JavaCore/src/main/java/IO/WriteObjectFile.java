package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjectFile {
    public static void main(String[] args) {
        String fileName = "person.data"; // Tên của tệp tin cần ghi đối tượng vào

        // Tạo một đối tượng Person
        Person person = new Person("John Doe", 30);

        try {
            // Khởi tạo một ObjectOutputStream để ghi đối tượng xuống tệp tin
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            // Ghi đối tượng xuống tệp tin
            outputStream.writeObject(person);
            outputStream.flush();
            // Đóng ObjectOutputStream sau khi ghi xong
            outputStream.close();

            System.out.println("Đối tượng đã được lưu vào tệp tin \"" + fileName + "\" thành công.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi đối tượng vào tệp tin.");
            e.printStackTrace();
        }
    }
}
