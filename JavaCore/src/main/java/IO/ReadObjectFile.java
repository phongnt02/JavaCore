package IO;
import java.io.*;

public class ReadObjectFile {
    public static void main(String[] args) {
        String fileName = "person.data"; // Tên của tệp tin cần đọc đối tượng từ đó

        try {
            // Khởi tạo một ObjectInputStream để đọc đối tượng từ tệp tin
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));

            // Đọc đối tượng từ tệp tin
            Person person = (Person) inputStream.readObject();

            // Đóng ObjectInputStream sau khi đọc xong
            inputStream.close();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
