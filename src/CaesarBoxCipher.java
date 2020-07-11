import java.util.*;

public class CaesarBoxCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message for Caesar Box Cipher: ");
            String message = makePerfectSquareLength(cleanMessage(input.nextLine()));

            char[][] cipherBox = addMessageToCaesarBox(message, (int) Math.sqrt(message.length()));

            System.out.println("\nCipher Box: ");
            printCipherBox(cipherBox);

            String secretMessage = cipherMessage(cipherBox);
            String decipheredMessage = decipherMessage(secretMessage);
            System.out.println("\nThe Ciphered Message: " + secretMessage.toUpperCase()
                    + "\nThe Decoded Message: " + decipheredMessage.toUpperCase() + "\n");
        }
    }

    public static String makePerfectSquareLength(String message) {
        int length = message.length();
        StringBuilder messageBuilder = new StringBuilder(message);
        while (length % Math.sqrt(length) != 0) {
            messageBuilder.append(".");
            length++;
        }
        message = messageBuilder.toString();
        return message;
    }

    public static String cleanMessage(String message) {
        message = message.replaceAll("\\s+", "");
        return message;
    }

    public static char[][] addMessageToCaesarBox(String message, int length) {
        char[][] cipherBox = new char[length][length];
        int counter = 0, row, column = 0;
        while (counter != message.length()) {
            for (row = 0; row < cipherBox.length; row++) {
                cipherBox[row][column] = message.charAt(counter);
                counter++;
                if (row == length - 1) column++;
            }
        }
        return cipherBox;
    }

    public static void printCipherBox(char[][] cipherBox) {
        for (char[] row : cipherBox) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static String cipherMessage(char[][] cipherBox) {
        StringBuilder cipherMessage = new StringBuilder();
        int row = 0, column;
        while (row != cipherBox.length) {
            for (column = 0; column < cipherBox.length; column++) {
                cipherMessage.append(cipherBox[row][column]);
                if (column == cipherBox.length - 1) row++;
            }
        }
        return cipherMessage.toString();
    }

    public static String decipherMessage(String secretMessage) {
        StringBuilder decipheredMessage = new StringBuilder();
        int length = (int) Math.sqrt(secretMessage.length());
        char[][] cipherBox = new char[length][length];
        int counter = 0, row = 0, column;
        while (counter != secretMessage.length()) {
            for (column = 0; column < cipherBox.length; column++) {
                cipherBox[row][column] = secretMessage.charAt(counter);
                if (column == cipherBox.length - 1) row++;
                counter++;
            }
        }
        column = 0;
        counter = 0;
        while (counter != secretMessage.length()) {
            for (row = 0; row < cipherBox.length; row++) {
                decipheredMessage.append(cipherBox[row][column]);
                if (row == cipherBox.length - 1) column++;
                counter++;
            }
        }
        return decipheredMessage.toString();
    }
}