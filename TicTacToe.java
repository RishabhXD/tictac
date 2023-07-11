import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] tictactoe = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tictactoe[i][j] = '_';
            }
        }
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        char comp = 'O';
        char winner = '_';
        while (winner == '_'){
            System.out.print("Enter Row ");
            int row = sc.nextInt();
            System.out.print("Enter Col ");
            int col = sc.nextInt();

            tictactoe[row][col] = player;
            int[] compVal = getRandom(tictactoe);
            tictactoe[compVal[0]][compVal[1]] = comp;

            printMat(tictactoe);
            winner = winner(tictactoe);
        }
        System.out.println("Winner is : " + winner);
    }
    public static int getRandomVal(){
        int ans = (int)(Math.random()*3);
        return ans;
    }

    public static int[] getRandom(char[][] tictactoe){
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tictactoe[i][j] == '_') {
                    empty.add(new int[]{i, j});
                }
            }
        }
        int randomIndex = (int) (Math.random() * empty.size());
        return empty.get(randomIndex);
    }


    public static void printMat(char[][] tictactoe){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| "+ tictactoe[i][j] + " |");
            }
            System.out.println();
        }
    }
    public static boolean checkFilled(char[][] tictactoe){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tictactoe[i][j] == '_'){
                    return false;
                }
            }
        }
        return true;
    }

    public static char winner(char[][] tictactoe){
        for (int i = 0; i < 3; i++) {
            if(tictactoe[i][0] == tictactoe[i][1] && tictactoe[i][1] == tictactoe[i][2] && tictactoe[i][2] != '_' ){
                return tictactoe[i][0];
            }
            if(tictactoe[0][i] == tictactoe[1][i] && tictactoe[1][i] == tictactoe[2][i] && tictactoe[2][i] != '_' ){
                return tictactoe[0][i];
            }
            if(tictactoe[0][0] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][2] && tictactoe[1][1] != '_'){
                return tictactoe[0][0];
            }
            if(tictactoe[0][2] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][2] && tictactoe[1][1] != '_'){
                return tictactoe[0][2];
            }
        }
        return '_';
    }
}
