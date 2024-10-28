
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] computers;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());

		computers = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			computers[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			String[] sa = bf.readLine().split(" ");
			int start = Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);

			computers[start].add(end);
			computers[end].add(start);
		}

		int result = bfs(1);

		System.out.println(result);

	}

	private static int bfs(int x) {
		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;

		while(!q.isEmpty()){
			x = q.poll();
			for(int i=0; i<computers[x].size(); i++){
				int next = computers[x].get(i);
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
				result++;
			}
		}

		return result;
	}
}