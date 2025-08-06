package oopApi.sec06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataEx {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("현재 날짜: " + date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strNow2 = sdf.format(date);
        System.out.println("현재 날짜(지정된 형식): " + strNow2);

        // Date is deprecated
    }
}
