import java.util.Scanner;

public class 사과를머거보자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (max < map[i][j])
						max = map[i][j];
				}
			}
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int apple = 1;
			int cnt = 0;
			int r = 0;
			int c = 0;
			int temp = 0;
			oo: while (true) {
//				System.out.println(cnt);
				int x = 0;
				int y = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 사과의 좌표 구하기
						if (map[i][j] == apple) {
							x = j;
							y = i;
						}
					}
				}
				outer: while (true) {
					if(apple==max+1) break oo;
					for (int l = temp; l < 4; l++) {
						while (true) {
							// 우 탐색
							if (c + dc[l] < N && l == 0) {
								c = c + dc[l];
								// 직선으로 사과 찾음
								if (r == y && c == x) {
									apple++;
									temp = l;
									break outer;
								}
								else if(r==y&&c<x) {
									continue;
								}
								else if(c==x&&r>y) {
									continue;
								}
								// 꺾으면 사과 있음
								else if (c == x && r != y) {
									cnt++;
									break;
								}
							} else if (l == 0) {
								cnt++;
								break;
							}
							// 하 탐색
							if (r + dr[l] < N && l == 1) {
								r = r + dr[l];
								// 사과 찾음
								if (r == y && c == x) {
									apple++;
									temp = l;
									break outer;
								}else if(r==y&&c<x) {
									continue;
								}
								else if (c != x && r == y) {
									cnt++;
									break;
								}
							} else if (l == 1) {
								cnt++;
								break;
							}
							// 좌 탐색
							if (c + dc[l] >= 0 && l == 2) {
								c = c + dc[l];
								// 직선으로 사과 찾음
								if (r == y && c == x) {
									apple++;
									temp = l;
									break outer;
								}
								// 꺾으면 사과 있음
								else if (c == x && r != y) {
									cnt++;
									break;
								}
								else if(r==y&&c<x) {
									cnt++;
									break;
								}
							} else if (l == 2) {
								cnt++;
								break;
							}
							// 상 탐색
							if (r + dr[l] >= 0 && l == 3) {
								r = r + dr[l];
								// 사과 찾음
								if (r == y && c == x) {
									apple++;
									temp = l;
									break outer;
								}else if(c<x && r==y) {
									cnt++;
									temp = 0;
									break;
								}
								else if(r==y&&c>x) {
									continue;
								}
								else if (c != x && r == y) {
									cnt++;
									temp = 0;
									break;
								}
							} else if (l == 3) {
								cnt++;
								temp = 0;
								break;
							}
						}
					}

				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}

	}
}
