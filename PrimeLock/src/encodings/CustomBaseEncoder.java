package encodings;

import java.math.BigInteger;

public class CustomBaseEncoder {
    // add the symbols that you want to include in the encoding here
    private static final String BaseSymbols =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +      // Uppercase Alphabet
                    "abcdefghijklmnopqrstuvwxyz" +      // Lowercase Alphabet
                    "0123456789"+                     // all numbers
                    "~`!@#$%^&*()-=_+{}[]|;:<>?/"+      // all standard symbols in Macbook keyboard
            "$_";

    // Radix
    // To know our current base of number (e.g. base-16 / radix-16)
    private static final int numberOfDigits = BaseSymbols.length();

    public static String CustomBaseEncoding(BigInteger inputNumber) {
        if (inputNumber.equals(BigInteger.ZERO)) {
            return "0";
        }

        StringBuilder encodedString = new StringBuilder();
        BigInteger base = BigInteger.valueOf(numberOfDigits);

        while (inputNumber.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = inputNumber.remainder(base);
            encodedString.insert(0, BaseSymbols.charAt(remainder.intValue()));
            inputNumber = inputNumber.divide(base);
        }
        return encodedString.toString();
    }

    public static BigInteger CustomBaseDecoding(String encoded) {
        BigInteger result = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(numberOfDigits);

        for (char c : encoded.toCharArray()) {
            int digit = BaseSymbols.indexOf(c);
            if (digit == -1) {
                throw new IllegalArgumentException("Invalid character in encoded string: " + c);
            }
            result = result.multiply(base).add(BigInteger.valueOf(digit));
        }
        return result;
    }

    public static String getBaseSymbols() {
        return BaseSymbols;
    }

    public static void main(String[] args) {

        System.out.print("We are now working with ");
        System.out.printf("Base-%d / radix-%d \n", numberOfDigits, numberOfDigits);

        System.out.printf("Characters/symbols in encoding: %s \n\n", BaseSymbols);

        // Tests\Examples
        long number1 = 9876543210L;  // 10-digit number


        bigIntTest("922337203685477");      // 15-digit


        bigIntTest("922337203685477922337203685477");       // 30-digit


    }

    public static void bigIntTest(String valutPassword) {
        BigInteger number = new BigInteger(valutPassword);  // 30-digit number

        System.out.println("Normal: " + number + "\t\t\t\t| Length = " + valutPassword.length());
        String encoded = CustomBaseEncoding(number);

        System.out.println("Encoded: " + encoded + "\t\t\t\t\t\t\t| Length = " + encoded.length());

        System.out.println();

    }
}
