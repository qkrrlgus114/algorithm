import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int humanIdx = Integer.MAX_VALUE;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = bf.readLine().split(" ");

		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			sa = bf.readLine().split(" ");
			int start = Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);

			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		System.out.println(humanIdx);
	}

	public static void bfs(int y) {
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, 0});
		boolean[] visited = new boolean[N + 1];
		visited[y] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cur = temp[0];
			int step = temp[1];

			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if (visited[next])
					continue;

				visited[next] = true;
				sum += step + 1;
				q.add(new int[] {next, step + 1});
			}
		}

		if (result == sum) {
			humanIdx = Math.min(humanIdx, y);
		} else if (result > sum) {
			result = sum;
			humanIdx = y;
		}
	}

}