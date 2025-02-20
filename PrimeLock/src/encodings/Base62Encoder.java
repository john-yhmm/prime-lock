package encodings;

import java.math.BigInteger;

public class Base62Encoder {
    private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // Uppercase Alphabet
            "abcdefghijklmnopqrstuvwxyz" +      // Lowercase Alphabet
            "0123456789";        // all numbers

    public static String encodeBase62(BigInteger number) {
        StringBuilder encoded = new StringBuilder();
        while (number.compareTo(BigInteger.ZERO) > 0) {
            encoded.append(BASE62.charAt(number.mod(BigInteger.valueOf(62)).intValue()));
            number = number.divide(BigInteger.valueOf(62));
        }
        return encoded.reverse().toString();
    }

    public static BigInteger decodeBase62(String encoded) {
        BigInteger number = BigInteger.ZERO;
        for (char c : encoded.toCharArray()) {
            number = number.multiply(BigInteger.valueOf(62)).add(BigInteger.valueOf(BASE62.indexOf(c)));
        }
        return number;
    }
}
