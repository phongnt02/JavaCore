package com.debt.service.utils.date;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 4:58 PM
 */
@UtilityClass
public class DateUtil {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

    public static Date convertStringToDate(String date) throws ParseException {
        return simpleDateFormat.parse(date);
    }
}
