package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("=== MENU ===");
            System.out.println("1. Gọi hàm không tham số");
            System.out.println("2. Gọi hàm có tham số");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = scanner.nextInt();

                exit = switch (choice) {
                    case 1 -> {
                        System.out.print("Nhập chuỗi: ");
                        String a = scanner.next();
                        System.out.println("Chuỗi vừa nhập: " + a);
                        callFunctionWithoutParameters();
                        yield false;
                    }
                    case 2 -> {
                        try {
                            System.out.print("Nhập tham số đầu tiên: ");
                            int param1 = scanner.nextInt();
                            System.out.print("Nhập tham số thứ hai: ");
                            int param2 = scanner.nextInt();
                            callFunctionWithParameters(param1, param2);
                        } catch (InputMismatchException e) {
                            System.out.println("Tham số nhập vào không hợp lệ. Vui lòng nhập số nguyên.");
                            scanner.nextLine();  // Đọc bỏ dòng thừa để tránh lặp vô hạn
                        }
                        yield false;
                    }
                    case 3 -> {
                        System.out.println("Thoát chương trình.");
                        yield true;
                    }
                    default -> {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        yield false;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số nguyên.");
                scanner.nextLine();  // Đọc bỏ dòng thừa để tránh lặp vô hạn
            }
            System.out.println();  // Dòng trống để tách biệt giữa các lựa chọn
        }

        scanner.close();
    }

    // Hàm không có tham số
    private void callFunctionWithoutParameters() {
        System.out.println("Hàm không có tham số được gọi.");
        // Thực hiện các xử lý tại đây
    }

    // Hàm có tham số
    private void callFunctionWithParameters(int param1, int param2) {
        System.out.println("Hàm có tham số được gọi với các tham số: " + param1 + ", " + param2);
        // Thực hiện các xử lý tại đây
    }
}
