import java.util.Scanner;

public class baek_2644_촌수계산_실버2_dfs {
	static int[][] map;
	static boolean[] visited;
	static int cnt = 0;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		min = sc.nextInt();
		max = sc.nextInt();
		int E = sc.nextInt();
		visited = new boolean[V+1];
		map = new int[V+1][V+1];
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			map[st][ed] = 1;
			map[ed][st] = 1;
		}
		DFS(max, 0);
		if(!visited[max] || !visited[min]) {
			System.out.println(-1);
		}
		
	}
	
	public static void DFS(int depth, int cnt) {
		
		visited[depth] = true;
		if(depth==min) {
			System.out.println(cnt);
			return;
		}
		for(int i=1; i<map.length; i++) {
			if(visited[i]) continue;
			
			if(map[depth][i]==1 && !visited[i]) {
				DFS(i,cnt+1);
			}
		}
	}
}
