package package2;

public class Operators {
    public static void main(String[] ignoredArgs) {
        int x = 10;
        x++;
        System.out.println(x); // 11
        ++x;
        System.out.println(x); // 12

        int x1 = 10;
        int y1;
        y1 = x1++; // Postfix increment: y1 gets the value of x1 before incrementing
        System.out.println(y1); // 10
        y1 = ++x1; // Prefix increment: y1 gets the value of x1 after incrementing
        System.out.println(y1); // 12

        x = 1;
        int y = 1;

        System.out.println(++x); // x is incremented before this line, so it will print 2
        System.out.println(y++); // y is incremented after this line, so it will print 1 and then y becomes 2

        x = 1;
        y = 1;
        System.out.println(++x + 10); // x is incremented before this line, so it will print 2 + 10 = 12
        System.out.println(y++ + 10); // y is incremented after this line, so it will print 11 and then y becomes 2
        System.out.println(y); // 2

        // binomial operators: +, -, *, /, %
        // Caution: Operation overflow can occur.
        int x2 = 1000000;
        int y2 = 1000000;

        int z2 = x2 * y2; // This will cause an overflow
        System.out.println(z2);

        long x3 = 1000000;
        long y3 = 1000000;
        long z3 = x3 * y3; // This will not cause an overflow
        System.out.println(z3); // 1,000,000,000,000

        // System.out.println(10/0); // This will throw an ArithmeticException: / by zero
        // This will print Infinity, as dividing by zero in floating-point arithmetic results in Infinity
        // System.out.println(10/0.0);

        // System.out.println(10 %0); // This will throw an ArithmeticException: / by zero
        // This will print NaN (Not a Number), as the modulus operation with zero is undefined in floating-point arithmetic
        // System.out.println(10 % 0.0);

        String city = "Seoul";
        String gu = "Gangnam";
        System.out.println(city + " " + gu);

        // Comparison operators: ==, !=, >, <, >=, <=
        System.out.println(x2 == y2); // true, because x2 and y2 have the same value
        System.out.println(x2 != y2); // false, because x2 and y2 have the same value

        // Compare strings
        System.out.println(city == gu); // false, because city and gu are different strings
        System.out.println(city != gu); // true, because city and gu are different strings

        String name1 = new String("Gildong");
        String name2 = new String("Gildong");
        System.out.println(name1 == name2); // false, because name1 and name2 are different String objects
        System.out.println(name1.equals(name2)); // true, because name1 and name2 have the same content

        // Logical operators: &&, ||, !, ^

        // Bitwise logical operators: &, |, ~, ^
        // & (AND): true if both operands are true
        // 45 is 0x00101101 in binary, 25 is 0x00011001 in binary
        System.out.println(45 & 25); // 0x00101101 & 0x00011001 = 0x00001001 (9 in decimal)

        // | (OR): true if at least one operand is true
        System.out.println(45 | 25); // 0x00101101 | 0x00011001 = 0x00111101 (61 in decimal)

        // ~ (NOT): inverts the bits
        System.out.println(~45); // ~0x00101101 = 0x11010010 (in two's complement, this is -46 in decimal)

        // ^ (XOR): true if only one operand is true
        System.out.println(45 ^ 25); // 0x00101101 ^ 0x00011001 = 0x00110100 (52 in decimal)

        // Bitwise shift operators: <<, >>, >>>
        // << (left shift): shifts bits to the left, filling with zeros
        int result = 1 << 3; // 1 is 0x00000001 in binary, left shift by 3 gives 0x00001000 (8 in decimal)
        System.out.println(result); // 8

        // >> (right shift): shifts bits to the right, preserving the sign bit
        result = 8 >> 2; // 8 is 0x00001000 in binary, right shift by 2 gives 0x00000010 (2 in decimal)
        System.out.println(result); // 2

        // >>> (unsigned right shift): shifts bits to the right, filling with zeros
        // -8 is 0x11111000 in binary (in two's complement),
        // unsigned right shift by 2 gives 0x00111110 (1,073,741,822 in decimal)
        result = -8 >>> 2;
        System.out.println(result); // 1,073,741,822

        // Substitution operators: +=, -=, *=, /=, %=
        int xVal = 100;
        xVal += 100; // xVal = xVal + 100
        System.out.println(xVal); // 200

        // Three-way conditional operator: { ? : }
        int score = 95;
        char grade = score >= 90 ? 'A' : 'B';
        System.out.println("Grade: " + grade); // Grade: A

        // Parentheses for precedence: ( ... )
        byte score_sub = (byte) score;
    }
}
