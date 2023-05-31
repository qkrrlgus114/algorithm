import java.util.Arrays;
import java.util.Scanner;

public class baek_바이러스_2606_실버3_dfs {
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		visited = new boolean[V+1];
		int[][] map = new int[V+1][V+1];
		int E = sc.nextInt();
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			map[st][ed]=1;
			map[ed][st]=1;
		}
		DFS(1,V,map);
		System.out.println(cnt);
		
	}
	
	public static void DFS(int depth, int V, int[][] map) {
		visited[depth] = true;
		for(int i=1; i<V+1; i++) {
			if(map[depth][i]==1 && !visited[i]) {
				cnt++;
				DFS(i, V, map);
			}
		}
	}
}
