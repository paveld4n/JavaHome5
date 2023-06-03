//* На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8

public class task3 {
    public static void main(String[] args) {
        int[] queens = new int[8];

        position (queens, 0);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col){
                    System.out.print(" X ");
                } else {
                    System.out.print(" 0 ");
                } 
            }
            System.out.println();
        }
    }

    public static boolean position(int[] array, int row) {
        
        if (row == array.length) {
            return true;
        } 
        for (int i = 0; i < array.length; i++) {
            boolean isRight = true;
            for (int j = 0; j < row; j++) {
                if (array[j] == i || array[j] == i - row + j || array[j] == i + row - j) {
                    isRight = false;
                    break;
                }
            }

            if (isRight) {
                array[row] = i;

                if (position(array, row + 1)){
                    return true;
                } 
            }
        }
        return false;
    }
}

