package encodings;

public class Base89Encoder {
    private static final String BASE =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +               // Uppercase Alphabet
                    "abcdefghijklmnopqrstuvwxyz" +      // Lowercase Alphabet
                    "0123456789" +                      // all numbers
                    "~`!@#$%^&*()-=_+{}[]|;:<>?/";      // all standard symbols in Macbook keyboard

    public static String encodeBase89(long number) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            encoded.insert(0, BASE.charAt((int) (number % BASE.length())));
            number /= BASE.length();
        }
        return encoded.toString();
    }

    public static String getBASE(){
        return BASE;
    }

    public static void main(String[] args) {
        System.out.print("Base-");
        System.out.println(getBASE().length());

        long number = 9876543210L;  // 10-digit number
        String encoded = encodeBase89(number);
        System.out.println("Base-89 Encoded: " + encoded);

        long number2 = 9876543211L;
        String encoded2 = encodeBase89(number2);
        System.out.println("Base-89 Encoded: " + encoded2);

    }
}


// added test comment
