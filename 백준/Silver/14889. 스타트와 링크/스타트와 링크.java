import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;


public class Main {

    static int result = Integer.MAX_VALUE;
    static int N;
    static int[] start;
    static int[] link;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String sN = bf.readLine();
        N = Integer.parseInt(sN);

        visited = new boolean[N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] s = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        back(0, 0);

        System.out.println(result);

    }

    public static void back(int depth, int count){
        // 종료 조건
        if(depth == N/2){
            // 스타트와 링크 팀의 팀원들 번호를 list에 저장
            int startIndex = 0;
            int linkIndex = 0;
            start = new int[N/2];
            link = new int[N/2];
            for(int i=0; i<N; i++){
                if(visited[i]) start[startIndex++] = i;
                else link[linkIndex++] = i;
            }
            // 각 팀의 점수를 계산
            int startPoint = 0;
            int linkPoint = 0;
            // 스타트 팀의 점수 계산
            for(int i=0; i<start.length; i++){
                for(int j=i; j<start.length; j++){
                    if(i == j) continue;
                    startPoint += map[start[i]][start[j]];
                    startPoint += map[start[j]][start[i]];
                }
            }

            // 링크 팀의 점수 계산
            for(int i=0; i<link.length; i++){
                for(int j=i; j<link.length; j++){
                    if(i == j) continue;
                    linkPoint += map[link[i]][link[j]];
                    linkPoint += map[link[j]][link[i]];
                }
            }

            if(result > Math.abs(startPoint - linkPoint)) result = Math.abs(startPoint - linkPoint);
            return;
        }

        for(int i=count; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                back(depth + 1, i+1);
                visited[i] = false;
            }
        }
    }
}