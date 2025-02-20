package encryption.SimpleCiphers;

public class XorCipher {
    public static String xorEncryptDecrypt(String text, char key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            /*
            XOR Property: For any value A, (A ^ B) ^ B = A. This means applying XOR with the same key twice returns the original value.
            Encrypt: plaintext ^ key → ciphertext
            Decrypt: ciphertext ^ key → plaintext
            Each character in "HELLO" is XORed with 'K' (ASCII value 75).
            Example: H (ASCII 72) → 72 ^ 75 = 3 (unprintable character).
            Plaintext: 01001000 (H)
            Key (K):   01001011
            XOR Result:00000011 (encrypted)

             */
            result.append((char) (character ^ key));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String message = "HELLO";
        char key = 'K';  // Encryption key

        String encrypted = xorEncryptDecrypt(message, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = xorEncryptDecrypt(encrypted, key);  // XOR again to decrypt
        System.out.println("Decrypted: " + decrypted);
    }
}
