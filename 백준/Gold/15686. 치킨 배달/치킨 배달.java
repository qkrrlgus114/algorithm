import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int N;
    static int M;
    static int[][] chicken_house;
    static int[][] house;
    static int[][] map;
    static boolean[] seleted;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        map = new int[N][N];

        int chicken_count = 0;
        int house_count = 0;
        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(sa[j]);
                if(map[i][j] == 1) house_count++;
                else if(map[i][j] == 2) chicken_count++;
            }
        }

        seleted = new boolean[chicken_count];
        chicken_house = new int[chicken_count][2];
        house = new int[house_count][2];
        int house_index = 0;
        int chicken_index = 0;


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    house[house_index][0] = i;
                    house[house_index++][1] = j;
                }else if(map[i][j] == 2){
                    chicken_house[chicken_index][0] = i;
                    chicken_house[chicken_index++][1] = j;
                }
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int depth, int index){
        // 종료 조건
        if(depth == M){
            int sum = 0;
            for(int i=0; i<house.length; i++){
                int distance = Integer.MAX_VALUE;
                int y1 = house[i][0];
                int x1 = house[i][1];
                for(int j=0; j<chicken_house.length; j++){
                    int temp_dis = 0;
                    // 선택한 치킨 집만 계산
                    if(seleted[j]){
                        int y2 = chicken_house[j][0];
                        int x2 = chicken_house[j][1];
                        temp_dis = Math.abs(y1 - y2) + Math.abs(x1 - x2);
                        if(distance > temp_dis) distance = temp_dis;
                    }
                }
                sum += distance;
                if(min < sum) return;
            }
            if(min > sum) min = sum;

            return;
        }

        for(int i=index; i<seleted.length; i++){
            if(!seleted[i]){
                seleted[i] = true;
                dfs(depth + 1, i + 1);
                seleted[i] = false;
            }
        }
    }
}