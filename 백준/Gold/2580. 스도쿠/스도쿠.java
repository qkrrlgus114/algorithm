import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[][] map = new int[9][9];
    // 0의 개수
    static int N = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            String[] s = bf.readLine().split(" ");
            for(int j=0; j<9; j++){
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 0) N++;
            }
        }

        back(0, 0);
    }

    public static void back(int row, int col){

        // 열이 다 채워졌으면
        if(col == 9){
            // 행 + 1, 열은 처음부터
            back(row + 1, 0);
            return;
        }

        // 행이 다 채워졌으면 출력
        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(map[row][col] == 0){
            // 1부터 9까지 전부 넣어봄
            for(int i=1; i<=9; i++){
                if(checkNumber(row, col, i)){
                    map[row][col] = i;
                    back(row, col + 1);
                }
            }
            map[row][col] = 0;
        }else{
            back(row, col + 1);
        }

    }

    public static boolean checkNumber(int i, int j, int value){

        // 행 확인(가로)
        for(int q=0; q<9; q++){
            // 이미 있으면 불가능
            if(map[i][q] == value){
                return false;
            }
        }

        // 열 확인(세로)
        for(int q=0; q<9; q++){
            if(map[q][j] == value){
                return false;
            }
        }

        for(int q=(i/3)*3; q<((i/3)*3)+3; q++){
            for(int k=(j/3)*3; k<((j/3)*3)+3; k++){
                if(map[q][k] == value){
                    return false;
                }
            }
        }

        return true;
    }
}