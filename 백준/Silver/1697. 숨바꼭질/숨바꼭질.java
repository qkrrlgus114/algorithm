import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, K = 0;
	static boolean[] visited = new boolean[100001];
	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		K = Integer.parseInt(sa[1]);

		if (N == K) {
			System.out.println(0);
		} else {
			int result = bfs();
			System.out.println(result);
		}
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		visited[N] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cur = temp[0];
			int second = temp[1];

			if (cur == K)
				return second;

			if (cur - 1 >= 0 && !visited[cur - 1]) {
				visited[cur - 1] = true;
				q.add(new int[] {cur - 1, second + 1});
			}

			if (cur + 1 <= 100000 && !visited[cur + 1]) {
				visited[cur + 1] = true;
				q.add(new int[] {cur + 1, second + 1});
			}

			if (cur * 2 <= 100000 && !visited[cur * 2]) {
				visited[cur * 2] = true;
				q.add(new int[] {cur * 2, second + 1});
			}
		}

		return 0;
	}
}