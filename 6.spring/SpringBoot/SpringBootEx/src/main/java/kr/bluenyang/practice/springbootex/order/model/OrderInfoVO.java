package kr.bluenyang.practice.springbootex.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfoVO {
    private String ordNo;
    private String ordDate;
    private String memId;
    private String ordReceiver;
    private String ordRcvZipCode;
    private String ordRcvAddress1;
    private String ordRcvAddress2;
    private String ordRcvPhone;
    private String ordRcvMsg;
    private String ordPay;
}
