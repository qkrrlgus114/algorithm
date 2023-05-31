package 스터디문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 맵이 주어지고 1은 집O, 0은 집X
// 상하좌우의 경우만 집이 연결돼 있다. 대각선 X
// 단지수 출력, 단지에 속하는 집의 수 오름차순 출력
// BFS로 1인 지점 완탐해서 다른 수로 덮어씌우자.

public class baek_2667_단지번호붙이기_실버1 {
	static int N;
	static int map[][];
	// 상하좌우 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	// 단지의 수를 저장해서 오름차순으로 정렬하기 위해서 list 사용
	static List<Integer> count = new ArrayList<Integer>();
	// 원본 맵은 유지하고 boolean맵으로 변경하면서 진행
	static boolean[][] visited;
	// 단지의 수
	static int danji = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		// 입력 받기
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j]==1) { // 1이면 visited도 true
					visited[i][j] = true;
				}
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					BFS(i,j);
				}
			}
		}
		System.out.println(danji);
		Collections.sort(count);
		for(int i=0; i<count.size(); i++) {
			System.out.println(count.get(i));
		}
	}
	static void BFS(int x, int y) {
		danji++; // 이게 실행되면 단지 +1
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		int cnt = 1;
		visited[x][y] = false;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++){
				int idr = x+dr[i];
				int idc = y+dc[i];
				// 범위 안에 있는지 체크
				if(idr>=0 && idc>=0 && idr<N && idc<N) {
					// 해당 부분이 true고 1인지 체크
					if(visited[idr][idc] && map[idr][idc]==1) {
						q.add(new int[] {idr, idc});
						cnt++;
						visited[idr][idc] = false;
					}
				}
			}
		}
		count.add(cnt);
	}
}
