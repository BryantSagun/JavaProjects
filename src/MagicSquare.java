import java.util.*;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Magic Square by Bryant Kyle");
        System.out.print("\nInput Size of Magic Square: ");

        int size = input.nextInt();
        int[][] magicSquare = testValues(createMagicSquare(size));

        printSquare(magicSquare);
        System.out.println();
        calculateAllSums(magicSquare);
    }

    public static int[][] createMagicSquare(int size) {
        return new int[size][size];
    }

    public static void printSquare(int[][] magicSquare) {
        for (int[] row : magicSquare) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void calculateAllSums(int[][] magicSquare){
        calculateRow(magicSquare);
        System.out.println();
        calculateColumn(magicSquare);
        System.out.println();
        calculateLRDiagonal(magicSquare);
        calculateRLDiagonal(magicSquare);
    }

    public static void calculateColumn(int[][] magicSquare) {
        int sum = 0, row, column = 0;

        System.out.println("SUM OF COLUMNS");
        while (column != magicSquare.length) {
            for (row = 0; row < magicSquare.length; row++) {
                sum += magicSquare[row][column];
            }
            System.out.println("COLUMN #" + (column + 1) + ": " + sum);
            sum = 0;
            column++;
        }
    }

    public static void calculateRow(int[][] magicSquare) {
        int sum = 0, row = 0, column;

        System.out.println("SUM OF ROWS");
        while (row != magicSquare.length) {
            for (column = 0; column < magicSquare.length; column++) {
                sum += magicSquare[row][column];
            }
            System.out.println("ROW #" + (row + 1) + ": " + sum);
            sum = 0;
            row++;
        }
    }

    public static void calculateLRDiagonal(int[][] magicSquare) {
        int sum = 0, row = 0, column;

        for (column = 0; column < magicSquare.length; column++) {
            sum += magicSquare[row][column];
            row++;
        }
        System.out.println("SUM OF LEFT TO RIGHT DIAGONAL: " + sum);
    }

    public static void calculateRLDiagonal(int[][] magicSquare) {
        int sum = 0, row = 0, column;

        for (column = magicSquare.length - 1; column >= 0; column--) {
            sum += magicSquare[row][column];
            row++;
        }
        System.out.println("SUM OF RIGHT TO LEFT DIAGONAL: " + sum);
    }

    

    // TEST METHODS
    public static int[][] testValues(int[][] magicSquare) {
        for (int row = 0, column = 0; row < magicSquare.length; row++) {
            magicSquare[row][column] = 10;
        }
        for (int row = 0, column = 1; column < magicSquare.length; column++) {
            magicSquare[row][column] = 20;
        }
        for (int row = 1, column = 1; column < magicSquare.length; column++) {
            magicSquare[row][column] = 30;
        }
        for (int row = 2, column = 1; column < magicSquare.length; column++) {
            magicSquare[row][column] = 40;
        }
        return magicSquare;
    }

    public static int getMagicNumber(int size) {
        int sizeSquared = size * size;
        return summation(sizeSquared) / size;
    }

    public static int summation(int size){
        return size == 1? 1 : size + summation(size - 1);
    }
}
