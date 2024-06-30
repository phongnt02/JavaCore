package Helper;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateHelperTest {

    @Test
    void parseDate_ValidDate_ReturnsDate() throws ParseException {
        // Arrange
        String dateString = "2024-05-17";
        String format = "yyyy-MM-dd";

        // Act
        Date parsedDate = DateHelper.parseDate(dateString, format);
        String formattedParsedDate = DateHelper.formatDate(parsedDate, format); // Chuyển đổi lại thành chuỗi

        // Assert
        assertEquals(dateString, formattedParsedDate);
    }


    @Test
    void formatDate_ValidDate_ReturnsString() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 17);
        Date date = calendar.getTime();
        String expectedDateString = "2024-05-17";
        assertEquals(expectedDateString, DateHelper.formatDate(date, "yyyy-MM-dd"));
    }

    @Test
    void calculateAge_ValidDateOfBirth_ReturnsAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.JANUARY, 1); // Ngày tháng năm sinh
        Date dateOfBirth = calendar.getTime();
        int expectedAge = Calendar.getInstance().get(Calendar.YEAR) - 1990; // Tuổi tính từ năm 1990 đến năm hiện tại
        assertEquals(expectedAge, DateHelper.calculateAge(dateOfBirth));
    }

    @Test
    void isLeapYear_ValidLeapYear_ReturnsTrue() {
        assertTrue(DateHelper.isLeapYear(2024)); // Năm nhuận
    }

    @Test
    void isLeapYear_ValidNonLeapYear_ReturnsFalse() {
        assertFalse(DateHelper.isLeapYear(2023)); // Năm không nhuận
    }
}
