package kr.bluenyang.practice.membercontrol.utils;

public class XSSPreventer {
    static public String execute(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            switch (ch) {
                case '<' -> result.append("&lt;");
                case '>' -> result.append("&gt;");
                case '&' -> result.append("&amp;");
                case '"' -> result.append("&quot;");
                case '\'' -> result.append("&#x27;");
                case '/' -> result.append("&#x2F;");
                default -> result.append(ch);
            }
        }
        return result.toString();
    }
}
