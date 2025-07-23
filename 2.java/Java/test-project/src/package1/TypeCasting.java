package package1;

public class TypeCasting {
    public static void main(String[] ignoredArgs) {
        // Type Casting in Java
        // The process of converting a variable from one data type to another.
        // Implicit(Automatic) Type Casting: Promotion
        // Explicit(Forceful) Type Casting: Casting

        // Implicit Type Casting: When the smaller data type is converted to a larger data type.
        // Can the long type allocate to a float type? 8 bytes to 4 bytes
        // byte < short < int < long < float < double

        // Automatic Type Casting
        int intVal = 10; // byte to int
        System.out.println(intVal);

        intVal = '가'; // value of 2 bytes to int
        System.out.println(intVal); // char to int

        float fltVal = (float) 258960; // long to float
        System.out.println(fltVal);

        intVal = (int) 25.369847f; // float to int
        System.out.println(intVal); // may lose data

        byte byteVal = (byte) 103029870;
        System.out.println(byteVal); // may lose data

        char chrVal = (char)44032;
        System.out.println(chrVal); // may lose data

        // Determining the type casting after check the range of the loss type of value
        // For the default type, Java consists of objects
        // default_type_object.MIN_VALUE / default_type_object.MAX_VALUE
        // ex. Int.MIN_VALUE / Int.MAX_VALUE
        // Loss occurs when casting integer value greater than the mantissa of the float number 23 bits to float type.
        
        int intVal2 = 10;
        double doubleVal2 = 5.5;
        
        double result = intVal2 + doubleVal2; // intVal2 is promoted to double
        System.out.printf("result = %s%n", result); // 15.5
        
        int intVal4 = intVal2 / 4;
        System.out.printf("intVal4 = %d%n", intVal4);
        System.out.println(intVal2 / 4.0);

        int intVal3 = (int)(intVal2 / 4.0); // Explicitly casting the result to int
        System.out.printf("intVal4 after casting = %d%n", intVal3); // 2
    }
}
