import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 제토경마토 {
	static int N;
	static int M;
	static int H;
	static int[][][] arr;
	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static boolean[][][] visited;
	static Queue<Integer> q1;
	static Queue<Integer> q2;
	static Queue<Integer> q3;
	static int cnt;
	static int cntmax;
	static int cntsum;
	static int[] sti;
	static int[] stj;
	static int[] stk;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][N][M];
		int size = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[k][i][j] = sc.nextInt();
					if (arr[k][i][j] == 1) {
						size++;
					}
				}
			}
		}
		sti = new int[size];
		stj = new int[size];
		stk = new int[size];

		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		q3 = new LinkedList<Integer>();
		visited = new boolean[H][N][M];
		cnt = 0;

		int idx = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 1) {
						sti[idx] = i;
						stj[idx] = j;
						stk[idx++] = k;
					}
				}
			}
		}

		BFS(0, 0, 0);
		cntmax = 0;
		boolean check = false;
//		for (int i = 0; i < M; i++)
//			System.out.println(Arrays.toString(arr[i]));
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cntmax = cntmax > arr[k][i][j] ? cntmax : arr[k][i][j];
					if (arr[k][i][j] == 0) {
						System.out.println(-1);
						check = true;
						return;
					}
				}
			}
		}
		for (int k = 0; k < H; k++) {
			System.out.println();
			for (int i = 0; i < N; i++)
				System.out.println(Arrays.toString(arr[k][i]));
		}
		if (!check) {
			System.out.println(cntmax - 1);
		}

	}

	static void BFS(int r, int c, int h) {
		for (int i = 0; i < sti.length; i++) {
			q1.add(sti[i]);
			q2.add(stj[i]);
			q3.add(stk[i]);
		}

		while (true) {
			if (q1.isEmpty()) {
				break;
			}
			int curri = q1.poll();
			int currj = q2.poll();
			int currk = q3.poll();

//			System.out.println(curri+" "+currj+" "+currk);
			for (int k = 0; k < 6; k++) {
				if (curri + dr[k] >= N || curri + dr[k] < 0 || currj + dc[k] >= M || currj + dc[k] < 0
						|| currk + dh[k] >= H || currk + dh[k] < 0) {
					continue;
				}
//				System.out.println(arr[currk + dh[k]][curri + dr[k]][currj + dc[k]]);
//				System.out.println(k);
//				System.out.println(currk + dh[k]);
//				System.out.println(curri + dr[k]);
//				System.out.println(currj + dc[k]);

				if (arr[currk + dh[k]][curri + dr[k]][currj + dc[k]] == 0
						&& !visited[currk + dh[k]][curri + dr[k]][currj + dc[k]]) {
					q1.add(curri + dr[k]);
					q2.add(currj + dc[k]);
					q3.add(currk + dh[k]);
					arr[currk + dh[k]][curri + dr[k]][currj + dc[k]] = arr[currk][curri][currj] + 1;
					visited[currk + dh[k]][curri + dr[k]][currj + dc[k]] = true;
				}
			}

		}

	}
}