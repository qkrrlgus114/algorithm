import java.util.Scanner;

public class swea_등산로조정 {
	static int[][] map; // 입력받을 맵
	static boolean[][] visited; // 방문체크
	static int K; // 최대 공사 횟수
	static int N; // 맵의 크기
	// 상, 하, 좌, 우를 탐색하기 위한 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 최대값 찾기
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			N = sc.nextInt();
			K = sc.nextInt(); // 땅파기
			map = new int[N][N];
			visited = new boolean[N][N]; // 방문체크
			int maxheight = 0; // 최대 봉우리
			// 봉우리 입력, 최대 봉우리 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (maxheight < map[i][j])
						maxheight = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxheight) { // 최대 봉우리면 시작
						DFS(i, j, 1, false); // 우선 땅을 안팠다고 주고 dfs 시작
					}
				}
			}
			System.out.printf("#%d %d\n",tc,max);
		}
	}

	public static void DFS(int x, int y, int cnt, boolean dig) {
		visited[x][y] = true;
		if(cnt>max) max = cnt;
		
		for (int i = 0; i < 4; i++) {
			int idx = x + dr[i];
			int idy = y + dc[i];
			if (idx >= 0 && idy >= 0 && idx < N && idy < N) {
				// 안파고 가도 되는 경우
				if (!visited[idx][idy] && map[x][y] > map[idx][idy]) {
					DFS(idx, idy, cnt + 1, dig); // dig는 변경이 없으니 그대로 넘긴다.
				}
				// 다음 봉우리가 더 높거나 같다면
				else if (map[x][y] <= map[idx][idy]) {
					// 방문 안 했고, 안 팠고, K만큼 팠을 때 작아지면
					if(!visited[idx][idy] && !dig && map[x][y] > map[idx][idy]-K) {
						int temp = map[idx][idy]; // 임시로 저장해놔야 돌아올 때 원상복구
						for(int j=1; j<=K; j++) { // 1부터 K까지 볼 건데
							if(map[idx][idy]-j < map[x][y]) { // j를 뺐을 때 map[x][y]가 크면
								map[idx][idy]-=j; // 빼고
								DFS(idx, idy, cnt + 1, true); // 팠다고 하고 DFS돈다.
								map[idx][idy] = temp; // 다시 원상복구
							}
						}
					}
				} 
			}
		}
		visited[x][y] = false;
	}
}
