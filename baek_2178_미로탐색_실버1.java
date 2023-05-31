import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2178_미로탐색_실버1 {
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static class Now{
		int x;
		int y;
		int cnt;
		
		public Now(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		visited = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		BFS(0,0,0);
		
		
	}
	
	public static void BFS(int x, int y, int cnt) {
		Queue<Now> q = new LinkedList<>();
		q.add(new Now(x, y, cnt+1));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Now now = q.poll();
			x = now.x;
			y = now.y;
			
			if(x==H-1 && y==W-1) {
				System.out.println(now.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int idx = x+dr[i];
				int idy = y+dc[i];
				
				if(idx>=0 && idy>=0 && idx<H && idy<W) {
					if(!visited[idx][idy] && map[idx][idy]==1) {
						q.add(new Now(idx, idy, now.cnt+1));
						visited[idx][idy] = true;
					}
				}
			}
		}
	}
}
