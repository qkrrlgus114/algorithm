import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
     * 1. 미세먼지 확산(4방향), 근처에 공청있거나 칸이 없으면 확산X
     * 2. 현재 미세먼지의 / 5, 소수점은 버린다.
     * 3. 전체에서 확산된 양 x 방향의 개수
     * 4. 공기청정기 작동
     * */

    static int R, C, T;
    // 공기청정기 좌표
    static int upCleanMachine;
    static int downCleanMachine;
    static int[][] arr;
    // 확산되는 먼지를 저장할 큐
    static Queue<Dust> q = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);
        T = Integer.parseInt(sa[2]);

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
                if (arr[i][j] == -1) downCleanMachine = i;
            }
        }
        upCleanMachine = downCleanMachine - 1;

        for (int i = 0; i < T; i++) {
            dustGenerated();
            upClean();
            downClean();
        }

        int result = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == -1) continue;
                result += arr[i][j];
            }
        }

        System.out.println(result);

    }

    // 미세먼지 확산
    private static void dustGenerated() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 0 이상이면 먼지
                if (arr[i][j] > 0) {
                    // 번식한 먼지
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        int ndy = i + dy[k];
                        int ndx = j + dx[k];
                        // 범위를 벗어나거나 공기청정기 위치면 건너뜀.
                        if (ndy < 0 || ndx < 0 || ndy >= R || ndx >= C) continue;
                        if (arr[ndy][ndx] == -1) continue;
                        int dust = (int) Math.floor(arr[i][j] / 5);
                        sum += dust;
                        // 큐에 먼지 저장
                        q.add(new Dust(ndy, ndx, dust));
                    }
                    // 전체 먼지 감소
                    arr[i][j] -= sum;
                }
            }
        }

        // 번식한 먼지 저장
        while (!q.isEmpty()) {
            Dust dust = q.poll();
            arr[dust.i][dust.j] += dust.quantity;
        }
    }

    // 공기청정기 위 동작
    private static void upClean() {
        // 아래
        for (int i = upCleanMachine - 1; i >= 0; i--) {
            // 공기청정기가 있으면 0으로 변경
            if (arr[i + 1][0] == -1) arr[i][0] = 0;
            else arr[i + 1][0] = arr[i][0];
        }
        // 왼쪽
        for (int j = 1; j < C; j++) {
            if (arr[0][j - 1] == -1) arr[0][j] = 0;
            else arr[0][j - 1] = arr[0][j];
        }
        // 위
        for (int i = 1; i <= upCleanMachine; i++) {
            arr[i - 1][C - 1] = arr[i][C - 1];
        }
        // 오른쪽
        for (int j = C - 2; j > 0; j--) {
            arr[upCleanMachine][j + 1] = arr[upCleanMachine][j];
            if(j == 1) arr[upCleanMachine][j] = 0;
        }

    }

    // 공기청정기 아래 동작
    private static void downClean() {
        // 위
        for (int i = downCleanMachine + 1; i < R; i++) {
            // 공기청정기가 있으면 0으로 변경
            if (arr[i - 1][0] == -1) arr[i][0] = 0;
            else arr[i - 1][0] = arr[i][0];
        }
        // 왼쪽
        for (int j = 1; j < C; j++) {
            if (arr[R - 1][j - 1] == -1) arr[R - 1][j] = 0;
            else arr[R - 1][j - 1] = arr[R - 1][j];
        }
        // 아래
        for (int i = R-2; i >= downCleanMachine; i--) {
            arr[i + 1][C - 1] = arr[i][C - 1];
        }
        // 오른쪽
        for (int j = C - 2; j > 0; j--) {
            arr[downCleanMachine][j + 1] = arr[downCleanMachine][j];
            if(j == 1) arr[downCleanMachine][j] = 0;
        }
    }
}

class Dust {
    int i;
    int j;
    int quantity;

    public Dust(int i, int j, int quantity) {
        this.i = i;
        this.j = j;
        this.quantity = quantity;
    }
}
