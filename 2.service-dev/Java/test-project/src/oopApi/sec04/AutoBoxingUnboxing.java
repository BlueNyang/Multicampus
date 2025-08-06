package oopApi.sec04;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        Integer obj = 100;
        System.out.println(obj.intValue());

        int value = obj;
        
        int result = obj + 100;
        System.out.println(result);
        Short.parseShort("100");
        Double.parseDouble("3.5");
        Boolean.parseBoolean("true");
    }
}
