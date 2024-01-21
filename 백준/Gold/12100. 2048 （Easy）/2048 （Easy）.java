import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        if (N == 1) {
            System.out.println(map[0][0]);
        } else {
            back(0);
            System.out.println(max);
        }


    }


    public static void back(int depth) {
        // 종료 (5번 전부 움직였으면 최대값 비교)
        if (depth == 5) {
            int temp_max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (temp_max < map[i][j]) temp_max = map[i][j];
                }
            }
            if (max < temp_max) max = temp_max;
            return;
        }

        // 상 우 하 좌 이동
        for (int q = 0; q < 4; q++) {
            int[][] copy = new int[N][N];
            // 카피본 생성 -> 원본 건드림 -> 카피본으로 다시 원본 복구
            copy = copyMap(copy, map);
            move(q);
            back(depth + 1);
            map = copyMap(map, copy);
        }
    }

    // 맵 복사
    public static int[][] copyMap(int[][] copy, int[][] origin) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    // 이동
    public static void move(int dir) {
        boolean[][] visited = new boolean[N][N];
        // 상
        if (dir == 0) {
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    if (map[i][j] != 0) {
                        int ndi = i - 1;
                        if (map[ndi][j] == 0) {
                            // 계속 위로 올라가면서 확인
                            while (true) {
                                if (ndi >= 0 && map[ndi][j] == 0) {
                                    map[ndi][j] = map[ndi + 1][j];
                                    map[ndi + 1][j] = 0;
                                }else if(ndi >= 0 && map[ndi][j] != 0){
                                    // 두 개가 다른 수면
                                    if(map[ndi][j] != map[ndi + 1][j]){
                                        if(check){
                                            visited[ndi + 1][j] = true;
                                        }
                                        break;
                                    }
                                    // 두 개가 같은 수면
                                    else{
                                        if(check){
                                            visited[ndi + 1][j] = true;
                                            break;
                                        }else{
                                            if(visited[ndi][j]) break;
                                            else{
                                                map[ndi][j] *= 2;
                                                map[ndi + 1][j] = 0;
                                                check = true;
                                            }
                                        }
                                    }
                                }else if(ndi < 0){
                                    if(check){
                                        visited[ndi+1][j] = true;
                                    }
                                    break;
                                }
                                ndi -= 1;
                            }
                        }else{
                            // 두 개가 다른 수면
                            if(map[ndi][j] != map[ndi + 1][j]){
                                if(check){
                                    visited[ndi + 1][j] = true;
                                    break;
                                }
                            }
                            // 두 개가 같은 수면
                            else{
                                if(check){
                                    visited[ndi + 1][j] = true;
                                    break;
                                }else{
                                    if(visited[ndi][j]) break;
                                    else{
                                        map[ndi][j] *= 2;
                                        map[ndi + 1][j] = 0;
                                        visited[ndi][j] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 하
        else if (dir == 1) {
            for (int i = N-2; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    if (map[i][j] != 0) {
                        int ndi = i + 1;
                        if (map[ndi][j] == 0) {
                            // 계속 아래로 내려가면서 확인
                            while (true) {
                                if (ndi < N && map[ndi][j] == 0) {
                                    map[ndi][j] = map[ndi - 1][j];
                                    map[ndi - 1][j] = 0;
                                }else if(ndi < N && map[ndi][j] != 0){
                                    // 두 개가 다른 수면
                                    if(map[ndi][j] != map[ndi - 1][j]){
                                        if(check){
                                            visited[ndi-1][j] = true;
                                        }
                                        break;
                                    }
                                    // 두 개가 같은 수면
                                    else{
                                        if(check){
                                            visited[ndi-1][j] = true;
                                            break;
                                        }else{
                                            if(visited[ndi][j]) break;
                                            else{
                                                map[ndi][j] *= 2;
                                                map[ndi - 1][j] = 0;
                                                check = true;
                                            }
                                        }
                                    }
                                }else if(ndi == N){
                                    if(check){
                                        visited[ndi-1][j] = true;
                                    }
                                    break;
                                }
                                ndi += 1;
                            }
                        }else{
                            // 두 개가 다른 수면
                            if(map[ndi][j] != map[ndi - 1][j]){
                                if(check){
                                    visited[ndi-1][j] = true;
                                    break;
                                }
                            }
                            // 두 개가 같은 수면
                            else{
                                if(check){
                                    visited[ndi-1][j] = true;
                                    break;
                                }else{
                                    if(visited[ndi][j]) break;
                                    else{
                                        map[ndi][j] *= 2;
                                        map[ndi-1][j] = 0;
                                        visited[ndi][j] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 우
        else if (dir == 2) {
            for (int j = N-2; j >= 0; j--) {
                for (int i = 0; i < N; i++) {
                    boolean check = false;
                    if (map[i][j] != 0) {
                        int ndj = j + 1;
                        if (map[i][ndj] == 0) {
                            // 계속 아래로 내려가면서 확인
                            while (true) {
                                if (ndj < N && map[i][ndj] == 0) {
                                    map[i][ndj] = map[i][ndj - 1];
                                    map[i][ndj - 1] = 0;
                                }else if(ndj < N && map[i][ndj] != 0){
                                    // 두 개가 다른 수면
                                    if(map[i][ndj] != map[i][ndj - 1]){
                                        if(check){
                                            visited[i][ndj - 1] = true;
                                        }
                                        break;
                                    }
                                    // 두 개가 같은 수면
                                    else{
                                        if(check){
                                            visited[i][ndj - 1] = true;
                                            break;
                                        }else{
                                            if(visited[i][ndj]) break;
                                            else{
                                                map[i][ndj] *= 2;
                                                map[i][ndj - 1] = 0;
                                                check = true;
                                            }
                                        }
                                    }
                                }else if(ndj == N){
                                    if(check){
                                        visited[i][ndj - 1] = true;
                                    }
                                    break;
                                }
                                ndj += 1;
                            }
                        }else{
                            // 두 개가 다른 수면
                            if(map[i][ndj] != map[i][ndj - 1]){
                                if(check){
                                    visited[i][ndj - 1] = true;
                                    break;
                                }
                            }
                            // 두 개가 같은 수면
                            else{
                                if(check){
                                    visited[i][ndj - 1] = true;
                                    break;
                                }else{
                                    if(visited[i][ndj]) break;
                                    else{
                                        map[i][ndj] *= 2;
                                        map[i][ndj -1] = 0;
                                        visited[i][ndj] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 좌
        else if (dir == 3) {
            for (int j = 1; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    boolean check = false;
                    if (map[i][j] != 0) {
                        int ndj = j - 1;
                        if (map[i][ndj] == 0) {
                            // 계속 아래로 내려가면서 확인
                            while (true) {
                                if (ndj >= 0 && map[i][ndj] == 0) {
                                    map[i][ndj] = map[i][ndj + 1];
                                    map[i][ndj + 1] = 0;
                                }else if(ndj >= 0 && map[i][ndj] != 0){
                                    // 두 개가 다른 수면
                                    if(map[i][ndj] != map[i][ndj + 1]){
                                        if(check){
                                            visited[i][ndj + 1] = true;
                                        }
                                        break;
                                    }
                                    // 두 개가 같은 수면
                                    else{
                                        if(check){
                                            visited[i][ndj + 1] = true;
                                            break;
                                        }else{
                                            if(visited[i][ndj]) break;
                                            else{
                                                map[i][ndj] *= 2;
                                                map[i][ndj + 1] = 0;
                                                check = true;
                                            }
                                        }
                                    }
                                }else if(ndj < 0){
                                    if(check){
                                        visited[i][ndj + 1] = true;
                                    }
                                    break;
                                }
                                ndj -= 1;
                            }
                        }else{
                            // 두 개가 다른 수면
                            if(map[i][ndj] != map[i][ndj + 1]){
                                if(check){
                                    visited[i][ndj + 1] = true;
                                    break;
                                }
                            }
                            // 두 개가 같은 수면
                            else{
                                if(check){
                                    visited[i][ndj + 1] = true;
                                    break;
                                }else{
                                    if(visited[i][ndj]) break;
                                    else{
                                        map[i][ndj] *= 2;
                                        map[i][ndj + 1] = 0;
                                        visited[i][ndj] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}
