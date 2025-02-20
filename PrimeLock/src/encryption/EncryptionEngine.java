package encryption;

import encodings.Base62Encoder;
import encryption.SimpleCiphers.CaesarCipher;

import java.math.BigInteger;

public class EncryptionEngine {
    public static String encrypt(String passcode, int a, int b, int c) {
        BigInteger number;
        try {
            number = new BigInteger(passcode);
        } catch (Exception e) {
            return "Invalid number!";
        }
        String encoded = Base62Encoder.encodeBase62(number);
        String encrypted = CaesarCipher.encrypt(encoded, a);
        encrypted = CaesarCipher.encrypt(encrypted, b);
        encrypted = CaesarCipher.encrypt(encrypted, c);
        return encrypted;
    }

    public static String decrypt(String encryptedStr, int a, int b, int c) {
        if ("".equals(encryptedStr))
            return "Invalid code!";
        String decrypted = CaesarCipher.decrypt(encryptedStr, c);
        decrypted = CaesarCipher.decrypt(decrypted, b);
        decrypted = CaesarCipher.decrypt(decrypted, a);
        BigInteger decoded = Base62Encoder.decodeBase62(decrypted);
        return decoded.toString();
    }
}
