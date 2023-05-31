package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
	static int[][] map; // 미로의 맵을 저장
	static int N;
	static int M;
	static boolean[][] visited; // 방문체크
	static int[][] result; // 미로의 결과 저장
	// 상 하 좌 우 탐색
	static int[] dr = { 1, -1, 0, 0 }; 
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0'; // 맵 입력 받기.
			}
		}
		
		BFS(0, 0);
		System.out.println(result[N-1][M-1]); // 결과배열의 마지막을 출력
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	// i와 j위치를 받는 BFS메서드를 만든다.
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>(); // int배열을 담을 수 있는 큐를 생성
		q.add(new int[] { x, y }); // 큐에 해당 좌표 값을 배열로 넣어준다.

		result[x][y] = 1; // 해당 좌표의 result 배열을 우선 1로 만들어준다.(거리 1 이동했다는 소리)

		while (!q.isEmpty()) {
			x = q.peek()[0]; // i좌표의 값을 x에 저장한다.
			y = q.peek()[1]; // j좌표의 값을 y에 저장한다.
			visited[x][y] = true; // 너 방문했어! 표시해준다.
			q.poll(); // poll을 이용해 큐를 비워준다.(위에서 x,y에 저장했으니)
			for (int i = 0; i < 4; i++) { // 사방탐색을 위해서
				int idr = dr[i] + x;
				int idc = dc[i] + y;
				// 맵 범위 안에 들어있고
				if (idr >= 0 && idc >= 0 && idr < N && idc < M) {
					// 해당 좌표가 1이고 아직 안들렸다면?
					if (map[idr][idc] == 1 && !visited[idr][idc]) {
						// 우선 result배열에 이전 위치+1을 해준다. 그러면 이전 위치는 1이었으니 2가 저장되고 그 다음에는 3이 저장되고..반복한다.
						result[idr][idc] = result[x][y] + 1;
						// 만약에 끝 지점에 도착했으면
						if(idr==N-1 && idc==M-1) {
							// 방문표시 해주고 return한다.
							visited[idr][idc] = true;
							return;
						}
						// 다시 큐에 해당 좌표를 넣어주고
						q.add(new int[] {idr, idc});
						// 방문 표시를 해준다.
						visited[idr][idc] = true;
					}
				}
			}
		}
	}
}
