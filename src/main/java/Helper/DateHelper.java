package Helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    // Phương thức chuyển đổi ngày tháng từ chuỗi sang đối tượng Date
    public static Date parseDate(String dateString, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

    // Phương thức chuyển đổi đối tượng Date thành chuỗi theo định dạng
    public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    // Phương thức tính tuổi từ ngày tháng năm sinh đến ngày hiện tại
    public static int calculateAge(Date dateOfBirth) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dateOfBirth);

        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // Kiểm tra nếu ngày sinh sau ngày hiện tại trong năm
        if (birthDate.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    // Phương thức kiểm tra xem một năm có phải là năm nhuận hay không
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
