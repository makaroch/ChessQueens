import java.util.Arrays;
import java.util.Random;

public class Chess {
    private static final Random random = new Random();
    public static void mainChess(int[][] intArrays, int countQueen){
        printArr(intArrays);
        int countOverwriting = 0;
        int count = 0;
        while (count < countQueen) {
            int i = random.nextInt(8);
            int j = random.nextInt(8);
            if (intArrays[i][j] == 0){
                intArrays[i][j] = 3;
                wreateOne(intArrays, i, j);
                count++;
            }
            if (!check(intArrays, count, countQueen)){// если нет свободный мест для ферзя, перезаписать массив
                countOverwriting++;
                overwriting(intArrays);
                count = 0;
            }
        }
        printArr(intArrays);
        System.out.println(countOverwriting + " кол-во перезаписей");
    }
    private static void overwriting(int[][] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = 0;
            }
        }
    }
    private static boolean check(int[][] arr, int count, int countQueen){
        int len = arr.length;
        if (count == countQueen){
            return true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    private static void wreateOne(int[][] arr,int row, int col){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[row][i] != 3){
                arr[row][i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i][col] != 3){
                arr[i][col] = 1;
            }
        }

        for (int i = row,j = col; i >= 0 && j >= 0; i--, j--) {//лева верх
            if (arr[i][j] != 3){
                arr[i][j] = 1;
            }
        }

        for (int i = row,j = col; i < len && j >= 0; i++, j--) {
            if (arr[i][j] != 3){
                arr[i][j] = 1;
            }
        }

        for (int i = row,j = col; i < len && j < len; i++, j++) {
            if (arr[i][j] != 3){
                arr[i][j] = 1;
            }
        }

        for (int i = row,j = col; i >= 0 && j < len; i--, j++) {// враво вверх
            if (arr[i][j] != 3){
                arr[i][j] = 1;
            }
        }

    }
    private static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
