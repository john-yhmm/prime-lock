package unusedcode;

import java.awt.GraphicsEnvironment;

public class FontListExample {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                                                .getAvailableFontFamilyNames();

        // Print all available fonts
        for (String font : fontNames) {
            System.out.println(font);
        }
    }
}