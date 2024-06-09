package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Tên của tệp tin cần đọc

        try {
            // Khởi tạo một BufferedReader để đọc dữ liệu từ tệp tin
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            // Đọc từng dòng từ tệp tin cho đến khi hết
            while ((line = reader.readLine()) != null) {
                // In dòng đã đọc ra màn hình
                System.out.println(line);
            }

            // Đóng BufferedReader sau khi đọc xong
            reader.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
