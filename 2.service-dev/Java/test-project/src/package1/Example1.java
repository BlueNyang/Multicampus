package package1;

public class Example1 {
    public static void main(String[] args) {
        // Java variables must be defined their type
        int value1; // Variable declaration
        int value = 10; // Variable declaration and initialization
        value1 = 10; // Allocation of value1
        int result = value1 + 10;

        System.out.println(result);

        // Java constants: running value memory temporary memory place (same as variable)
        // The running value does not change after initialization
        // Usage: final keyword = value;
        // Constants are usually defined in uppercase letters to distinguish them from variables
        final int PRICE = 100;
        // PRICE = 200; // This line would cause a compilation error

        // literals: fixed values in the code
        // Integer, Float, String, Boolean literals
        value = 50; // 50 Integer literal
        float val_f = 50.2f; // Float literal
        char val_ch = 'a'; // Character literal
        String str = "abc"; // String literal
        boolean a = true; // Boolean literal

        // Data Types
        // Default data Types:
        //      byte/short/int(default)/long
        //      float/double(default)
        //      boolean, char

        int a_int = 10; // default 0
        double b_double = 5.2; // default 0.0d
        char chr = 'A'; // default '\u0000'
        boolean bool = false; // default false

        long lint = 100L; // 8 bytes
        // long lin2 = 100,010,001,000; // out of range
        float flt = 5.0f; // 4 bytes
        short s_int = 10; // 2 bytes
        byte bte = 1; // 1 byte

        // Usage memory size is different for each data type
        // Memory Minimum Unit: bit -> 0/1 -> byte when 8 bits are grouped together

        // Floating Point Numbers
        // Decimal 12.375 represented as floating point number == 1.2375 * 10^1
        // Decimal 314.1592 => 3.141592 * 10^2
        float avg = 88.5f;
        double avg1 = 88.5; // double is more precise than float
        // with e
        double var3 = 3e6; // 3 * 10^6
        float var4 = 2e-3f; // 2 * 10^-3

        System.out.println(var3);
        System.out.println(var4);

        System.out.println(true);

        String name = "Gilding Hong";
        char firstName = 'G';
        System.out.println(name);
        System.out.println(firstName);


    }
}
