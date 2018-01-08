package pe.kapcom.coravi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by JRaffo on 2/01/17.
 */

public class CoraviUtil {
    public static String generateToken(String customerCode){

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm"+customerCode);
        String strDate = sdf.format(cal.getTime());

        return strDate;
    }
}
