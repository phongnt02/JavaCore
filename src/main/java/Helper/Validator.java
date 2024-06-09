package Helper;

import java.util.regex.Pattern;

public class Validator {

    // Khai báo các đối tượng Pattern dưới dạng static final để tái sử dụng
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d{1,3}[- ]?)?\\d{10}$");
    private static final Pattern URL_PATTERN = Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    // Phương thức kiểm tra định dạng email
    public static boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && EMAIL_PATTERN.matcher(email).matches();
    }

    // Phương thức kiểm tra định dạng số điện thoại
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty() && PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    // Phương thức kiểm tra định dạng URL
    public static boolean isValidURL(String url) {
        return url != null && !url.isEmpty() && URL_PATTERN.matcher(url).matches();
    }

    // Phương thức kiểm tra chuỗi không rỗng và không chỉ chứa khoảng trắng
    public static boolean isNonEmptyString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Phương thức kiểm tra chuỗi chỉ chứa chữ cái
    public static boolean isAlphabetic(String str) {
        return str != null && !str.isEmpty() && str.chars().allMatch(Character::isLetter);
    }

    // Phương thức kiểm tra chuỗi chỉ chứa chữ cái và số
    public static boolean isAlphanumeric(String str) {
        return str != null && !str.isEmpty() && str.chars().allMatch(Character::isLetterOrDigit);
    }

    // Phương thức kiểm tra chuỗi có phải là số nguyên
    public static boolean isInteger(String str) {
        return str != null && !str.isEmpty() && INTEGER_PATTERN.matcher(str).matches();
    }

    // Phương thức kiểm tra độ dài chuỗi
    public static boolean isLengthInRange(String str, int minLength, int maxLength) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }

    // Phương thức kiểm tra định dạng ngày tháng (định dạng yyyy-MM-dd)
    public static boolean isValidDate(String date) {
        return date != null && !date.isEmpty() && DATE_PATTERN.matcher(date).matches();
    }

    // Phương thức kiểm tra chuỗi có phải là số thập phân với số lượng chữ số thập phân xác định
    public static boolean isValidDecimal(String str, int decimalPlaces) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // Biểu thức chính quy để kiểm tra số thập phân với số lượng chữ số thập phân xác định
        String decimalRegex = "^\\d+\\.\\d{" + decimalPlaces + "}$";
        Pattern decimalPattern = Pattern.compile(decimalRegex);
        return decimalPattern.matcher(str).matches();
    }
}
