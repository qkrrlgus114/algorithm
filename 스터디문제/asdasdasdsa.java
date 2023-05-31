package 스터디문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class asdasdasdsa {
    static int N, M;
    static int[][] arr;
    static int[][] cntArr; // 방문배열이면서 최단거리 기록할 배열
    static int[][] flood;  // 홍수 배열
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    static Queue<Integer> f1;
    static Queue<Integer> f2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        cntArr = new int[N][M];
        flood = new int[N][M];

        int starti = 0;
        int startj = 0;

        int endi = 0;
        int endj = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'S') { // 출발점은 배열에 넣진 않고 따로 체크해서 파라미터로 넣기
                    starti = i;
                    startj = j;
                } else if (str.charAt(j) == 'D') { // 도착점
                    arr[i][j] = -2;
                    endi = i;
                    endj = j;
                } else if (str.charAt(j) == '*') {  // 물은 원 배열이랑 홍수배열에 넣기
                    arr[i][j] = 1;
                    flood[i][j] = 1;
                } else if (str.charAt(j) == 'X') { // 돌
                    arr[i][j] = 2;
                }
            }
        }

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        f1 = new LinkedList<>();
        f2 = new LinkedList<>();

        BFS(starti, startj);

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(cntArr[i]));
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(flood[i]));
        }
        System.out.println();
        if (cntArr[endi][endj] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(cntArr[endi][endj]); // 도착점까지의 거리
        }
    }

    static void BFS(int r, int c) {

        for (int i = 0; i < N; i++) { // 홍수 카운트 배열 먼저 만들어서 각 위치에 물이 도착한 시간을 비교하며 방문 가능여부 확인
            for (int j = 0; j < M; j++) {
                if (flood[i][j] == 1) {
                    f1.add(i);
                    f2.add(j);
                }
            }
        }

        while (!f1.isEmpty()) { // 무난하게 BFS
            int flen = f1.size(); 
            for (int i = 0; i < flen; i++) {
                int fi = f1.poll();
                int fj = f2.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = fi + dr[k];
                    int nc = fj + dc[k];

                    if (nr >= N || nc >= M || nr < 0 || nc < 0) {
                        continue;
                    }

                    if (arr[nr][nc] == 0 && flood[nr][nc] == 0) {
                        f1.add(nr);
                        f2.add(nc);
                        flood[nr][nc] = flood[fi][fj] + 1;
                    }
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(flood[i]));
//        }
//        System.out.println();

        q1.add(r); 
        q2.add(c);

        cntArr[r][c] = 1;
//        int idx = 1;
        while (!q1.isEmpty()) {
            int len = q1.size();
            for (int i = 0; i < len; i++) {
                int curri = q1.poll();
                int currj = q2.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = curri + dr[k];
                    int nc = currj + dc[k];

                    if (nr >= N || nc >= M || nr < 0 || nc < 0) {
                        continue;
                    }
                    if (arr[nr][nc] == -2) { // 도착했을떄 리턴
                        cntArr[nr][nc] = cntArr[curri][currj];
                        return;
                    }
                    if (arr[nr][nc] == 0 && cntArr[nr][nc] == 0) {
                        if (flood[nr][nc] == 0) { // 홍수가 도달 못하는데면 이동하기
                            q1.add(nr);
                            q2.add(nc);
                            cntArr[nr][nc] = cntArr[curri][currj] + 1;
                        } else { // 홍수가 도달 하는덴데
                            if (flood[nr][nc] > cntArr[curri][currj] + 1) { // 홍수가 고슴보다 늦게올떄는 이동 가능 
                                q1.add(nr);
                                q2.add(nc);
                                cntArr[nr][nc] = cntArr[curri][currj] + 1;
                            }
                        }

                    }

                }
            }
//            System.out.println(idx++);
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(cntArr[i]));
//            }
//            System.out.println();

        }
    }

}