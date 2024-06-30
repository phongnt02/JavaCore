package JPL.Practice.T01;

public class Main {
    public static void main(String[] args) {
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        System.out.println("-- Input data : ");
        phoneBookManagement.inputData();
        System.out.println(phoneBookManagement);
        phoneBookManagement.deleteByGroup("Family");
        phoneBookManagement.save();
    }
}
