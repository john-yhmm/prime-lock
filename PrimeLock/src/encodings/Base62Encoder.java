package encodings;
/*
Encoding & Compression
A 10-digit number can hold values from 0000000000 to 9999999999. The total possible values are:
1010=10,000,000,000 (10 billion unique numbers)10^{10} = 10,000,000,000 \text{ (10 billion unique numbers)}1010=10,000,000,000 (10 billion unique numbers)
We need to fit this into a 5-character alphanumeric string.
•	Alphanumeric set: "A-Z", "a-z", "0-9" → 62 possible characters.
•	5 characters of base-62 can hold: 625=916,132,83262^5 = 916,132,832625=916,132,832 which is not enough for 10 billion values.
•	6 characters of base-62 can hold: 626=56,800,235,58462^6 = 56,800,235,584626=56,800,235,584 which covers our range but is more than 5 characters.
Solution: Base Conversion (Base-10 → Base-62)
We can convert a 10-digit number from Base-10 to Base-62 and truncate or optimize the output.

 */
public class Base62Encoder {
    private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // Uppercase Alphabet
            "abcdefghijklmnopqrstuvwxyz" +      // Lowercase Alphabet
            "0123456789";        // all numbers

    public static String encodeBase62(long number) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            encoded.insert(0, BASE62.charAt((int) (number % 62)));
            number /= 62;
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        long number = 9876543210L;  // 10-digit number
        String encoded = encodeBase62(number);
        System.out.println("Base-62 Encoded: " + encoded);

        long number2 = 9876543211L;
        String encoded2 = encodeBase62(number2);
        System.out.println("Base-62 Encoded: " + encoded2);
    }
}
