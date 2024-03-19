import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] chess_board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        chess_board = new int[N][N];

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int queen){
        // 종료
        if(queen == N){
            result++;
            return;
        }

        // 재귀
        for(int i=0; i<N; i++){
            if(chess_board[queen][i] == 0 && checkQueen(queen, i)){
                chess_board[queen][i] = 1;
                dfs(queen + 1);
                chess_board[queen][i] = 0;
            }
        }

    }

    public static boolean checkQueen(int y, int x){
        // 위, 왼쪽위, 오른쪽위 확인
        int i = y;
        int j = x;
        // 1. 위 확인
        while(i >= 0){
            if(chess_board[i][j] != 0) return false;
            i--;
        }

        i = y;
        j = x;
        // 2. 왼쪽 위 확인
        while(i >= 0 && j >= 0){
            if(chess_board[i][j] != 0) return false;
            i--;
            j--;
        }

        i = y;
        j = x;
        // 3. 오른쪽 위 확인
        while(i >= 0 && j < N){
            if(chess_board[i][j] != 0) return false;
            i--;
            j++;
        }
        return true;
    }
}
