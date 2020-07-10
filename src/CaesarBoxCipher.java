import java.util.*;
public class CaesarBoxCipher
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Enter message for encryption: ");
            String message = input.nextLine();

            message = cleanMessage(message);

            boolean checkCharLength = isPerfectSquareLength(message);
            if(!checkCharLength) message = makePerfectSquareLength(message);

            char[][] cipherBox = addMessageToCaesarBox(message, (int)Math.sqrt(message.length()));

            printCipherBox(cipherBox);

            String secretMessage = cipherMessage(cipherBox);
            String decipheredMessage = decipherMessage(secretMessage);
            System.out.println("\nThe Secret Message: " + secretMessage.toUpperCase()
            +"\nThe Original Message: " + decipheredMessage.toUpperCase() + "\n");
        }
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

    public static char[][] addMessageToCaesarBox(String message, int length){
        char[][] cipherBox = new char[length][length];
        int counter = 0, row = 0, column = 0;
        while(counter!=message.length()){
            for(row=0; row<cipherBox.length; row++) {
                cipherBox[row][column] = message.charAt(counter);
                counter++;
                if(row == length-1) column++;
            }
        }
        return cipherBox;
    }

    public static void printCipherBox(char[][] cipherBox){
        System.out.println("\nCipher Box: ");
        for(char[] row: cipherBox){
            System.out.println(Arrays.toString(row));
        }
    }

    public static String cipherMessage(char[][] cipherBox){
        String cipherMessage = "";
        int row = 0, column = 0;
        while(row!=cipherBox.length){
            for(column=0; column<cipherBox.length; column++){
                cipherMessage += cipherBox[row][column];
                if(column==cipherBox.length-1) row++;
            }
        }
        return cipherMessage;
    }

    public static String decipherMessage(String secretMessage){
        String decipheredMessage = "";
        int length = (int) Math.sqrt(secretMessage.length());
        char[][] cipherBox = new char[length][length];
        int counter = 0, row = 0, column;
        while(counter!=secretMessage.length()){
            for(column = 0; column<cipherBox.length; column++){
                cipherBox[row][column] = secretMessage.charAt(counter);
                if(column == cipherBox.length-1) row++;
                counter++;
            }
        }
        column = 0;
        counter = 0;
        while(counter!=secretMessage.length()){
            for(row = 0; row<cipherBox.length; row++){
                decipheredMessage += cipherBox[row][column];
                if(row == cipherBox.length-1) column++;
                counter++;
            }
        }
        return decipheredMessage;
    }
}
