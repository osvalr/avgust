package pe.kapcom.iemail.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JRaffo on 9/02/17.
 */
public class AppUtil {
    public static String dateToString(Date date, String format){
        //fecha
        SimpleDateFormat sdf = new SimpleDateFormat(format); // Set your date format
        String str = sdf.format(date); // Get Date String according to date format
        return str;
    }
    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format
        String str = sdf.format(date); // Get Date String according to date format
        return str;
    }
}
