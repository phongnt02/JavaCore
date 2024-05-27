package JPL.Practice.T01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class PhoneBookManagement {
    private List<PhoneBook> listOfPhoneBook;

    public PhoneBookManagement() {
        this.listOfPhoneBook = new ArrayList<>();
    }

    public PhoneBookManagement(List<PhoneBook> listOfPhoneBook) {
        super();
        this.listOfPhoneBook = listOfPhoneBook;
    }

    @Override
    public String toString() {
        return "PhoneBookManagement{" +
                "listOfPhoneBook=" + listOfPhoneBook +
                '}';
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== MENU ===");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = scanner.nextInt();

                exit = switch (choice) {
                    case 1 -> {
                        System.out.println("Nhap ten: ");
                        String name = scanner.next();

                        System.out.println("Nhap so dien thoai");
                        Set<String> phoneNumber = new HashSet<>();
                        String phone = scanner.next();
                        System.out.println("Chọn 0 để hoàn thành nhâp sdt và chọn 1 để nhập thêm sdt khacs");
                        int choiceInputPhone = scanner.nextInt();
                        if (choiceInputPhone == 1) {
                            String phoneOther = scanner.next();
                            phoneNumber.add(phoneOther);
                        }
                        System.out.println("Nhap email: ");
                        String email = scanner.next();
                        if (!(Validator.isValidEmail(email) && Validator.isLengthInRange(email))) {
                            System.out.println("Sai dinh dang va do dai nho hon 6: ");
                            System.out.println("Nhap lai email:");
                            email = scanner.next();
                        }
                        System.out.println("Nhap address: ");
                        String address = scanner.next();
                        System.out.println("Nhap group: ");
                        String group = scanner.next();
                        System.out.println("Nhap date: ");
                        String date = scanner.next();
                        PhoneBook phoneBook = new PhoneBook(name, phoneNumber, email, address, group, new Date());
                        this.listOfPhoneBook.add(phoneBook);
                        yield false;
                    }
                    case 2 -> {
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
                scanner.nextLine();
            }
            System.out.println();
        }
    }

    public Set<String> findByName(String name) {
        Set<String> list = new HashSet<>();
        this.listOfPhoneBook.stream()
                .filter(phoneBook -> phoneBook.findByName(name))
                .forEach(phoneBook -> {
                    list.addAll(phoneBook.getPhoneNumber());
                });

        return list;
    }

    public Boolean deleteByGroup(String group) {
        Iterator<PhoneBook> iterator = listOfPhoneBook.iterator();
        while (iterator.hasNext()) {
            PhoneBook phoneBook = iterator.next();
            if (phoneBook.isGroup(group)) {
                iterator.remove();
            }
        }
        return true;
    }

    public Boolean save() {
        if(this.listOfPhoneBook.size() == 0 || this.listOfPhoneBook == null) return  false;

        String fileName = "phonebook.txt";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            for (PhoneBook phonebook : this.listOfPhoneBook){
                outputStream.writeObject(phonebook);
            }
            outputStream.flush();
            outputStream.close();
            System.out.println("Đối tượng đã được lưu vào tệp tin \"" + fileName + "\" thành công.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi đối tượng vào tệp tin.");
            e.printStackTrace();
        }
        return true;
    }
}
