import java.util.*;
public class CaesarBoxCipher
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter message for encryption: ");
        String message = input.nextLine();

        message = cleanMessage(message);

        boolean checkCharLength = isPerfectSquareLength(message);
        if(!checkCharLength) message = makePerfectSquareLength(message);
        int intSqrtOfMessageLength = (int)Math.sqrt(message.length());

        char[] messageChar = messageToCharArray(message);
        char[][] cipherBox = addMessageToCaesarBox(messageChar, intSqrtOfMessageLength);

        printCipherBox(cipherBox);
        printCipherMessage(cipherBox, intSqrtOfMessageLength);
    }

    public static char[] messageToCharArray(String message){
        char[] messageChar = new char[message.length()];
        for(int i=0; i<message.length(); i++){
            messageChar[i] = message.charAt(i);
        }

        return messageChar;
    }

    public static boolean isPerfectSquareLength(String message){
        if(message.length()%Math.sqrt(message.length())==0){
            return true;
        }
        return false;
    }

    public static String makePerfectSquareLength(String message){
        int length = message.length();
        while(length%Math.sqrt(length)!=0){
            message+=".";
            length++;
        }
        return message;
    }

    public static String cleanMessage(String message){
        message = message.replaceAll("\\s+", "");
        message = message.toLowerCase();

        return message;
    }

    public static char[][] addMessageToCaesarBox(char[] messageChar, int length){
        char[][] cipherBox = new char[length][length];
        int counter = 0, row = 0, column = 0;
        while(counter!=messageChar.length){
            for(row=0; row<cipherBox.length; row++) {
                cipherBox[row][column] = messageChar[counter];
                counter++;
                if(row == length-1) column++;
            }
        }

        return cipherBox;
    }

    public static void printCipherBox(char[][] cipherBox){
        for(char[] row: cipherBox){
            System.out.println(row);
        }
    }

    public static void printCipherMessage(char[][] cipherBox, int length){
        String cipherMessage = "";
        int row = 0, column = 0;
        while(row!=cipherBox.length){
            for(column=0; column<cipherBox.length; column++){
                cipherMessage += cipherBox[row][column];
                if(column==cipherBox.length-1) row++;
            }
        }
        System.out.println("Secret Message: " + cipherMessage);
    }
}
