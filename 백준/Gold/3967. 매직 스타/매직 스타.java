import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    static char[][] arr = new char[5][9];
    static boolean[] visited = new boolean[12];
    static List<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        for(int i=0; i<5; i++){
            char[] sa = bf.readLine().toCharArray();
            arr[i] = sa;
        }

        // 사용 알파벳 체크
        for(int i=0; i<5; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j] >= 'A' && arr[i][j] <= 'L'){
                    visited[arr[i][j] - 'A'] = true;
                }else if(arr[i][j] == 'x'){
                    list.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int depth){
        // 종료 조건
        if(depth == list.size()){
            if(check()){
                for(int i=0; i<5; i++){
                    for(int j=0; j<9; j++){
                        sb.append(arr[i][j]);
                    }
                    sb.append("\n");
                }
                System.out.println(sb.toString());
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<12; i++){
            if(visited[i]) continue;
            int[] temp = list.get(depth);
            // 해당 좌표에 가능한 알파벳 투입
            arr[temp[0]][temp[1]] = (char) (i + 'A');
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
            arr[temp[0]][temp[1]] = 'x';
        }
    }

    private static boolean check(){
        int sum1 = (arr[0][4] - 'A' + 1) + (arr[1][3] - 'A' + 1) + (arr[2][2] - 'A' + 1) + (arr[3][1] - 'A' + 1);
        int sum2 = (arr[0][4] - 'A' + 1) + (arr[1][5] - 'A' + 1) + (arr[2][6] - 'A' + 1) + (arr[3][7] - 'A' + 1);
        int sum3 = (arr[1][1] - 'A' + 1) + (arr[1][3] - 'A' + 1) + (arr[1][5] - 'A' + 1) + (arr[1][7] - 'A' + 1);
        int sum4 = (arr[1][1] - 'A' + 1) + (arr[2][2] - 'A' + 1) + (arr[3][3] - 'A' + 1) + (arr[4][4] - 'A' + 1);
        int sum5 = (arr[1][7] - 'A' + 1) + (arr[2][6] - 'A' + 1) + (arr[3][5] - 'A' + 1) + (arr[4][4] - 'A' + 1);
        int sum6 = (arr[3][1] - 'A' + 1) + (arr[3][3] - 'A' + 1) + (arr[3][5] - 'A' + 1) + (arr[3][7] - 'A' + 1);
        if(sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26) return true;
        return false;
    }
}

