
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static int N, M, V;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);
		V = Integer.parseInt(sa[2]);

		graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			sa = bf.readLine().split(" ");
			int start = Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);

			graph[start].add(end);
			graph[end].add(start);
		}

		for (List<Integer> list : graph) {
			Collections.sort(list);
		}

		boolean[] visited = new boolean[N + 1];

		sb.append(V).append(" ");
		visited[V] = true;
		dfs(V, visited);
		sb.append("\n");

		bfs(V);

		System.out.println(sb);
	}

	private static void bfs(int x) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(x);
		boolean[] visited = new boolean[N + 1];
		visited[x] = true;
		sb.append(x).append(" ");

		while (!pq.isEmpty()) {
			x = pq.poll();
			for (int i = 0; i < graph[x].size(); i++) {
				int next = graph[x].get(i);
				if (visited[next])
					continue;
				visited[next] = true;
				pq.add(next);
				sb.append(next).append(" ");
			}
		}
	}

	private static void dfs(int x, boolean[] visited) {
		for (int i = 0; i < graph[x].size(); i++) {
			int next = graph[x].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			sb.append(next).append(" ");
			dfs(next, visited);
		}
	}

}