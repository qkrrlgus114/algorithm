import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	static int N, M;
	static char[][] graph;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = bf.readLine().split(" ");
		M = Integer.parseInt(sa[0]);
		N = Integer.parseInt(sa[1]);

		graph = new char[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++){
			graph[i] = bf.readLine().toCharArray();
		}

		int white = 0;
		int blue = 0;

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(visited[i][j]) continue;

				if (graph[i][j] == 'W') {
					white += bfs(i, j, 'W');
				}else{
					blue += bfs(i, j, 'B');
				}
			}
		}

		System.out.println(white + " " + blue);
	}

	private static int bfs(int y, int x, char color){
		int result = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y, x});
		visited[y][x] = true;

		while(!q.isEmpty()){
			int[] temp = q.poll();
			y = temp[0];
			x = temp[1];

			for(int i=0; i<4; i++){
				int ny = dy[i] + y;
				int nx = dx[i] + x;

				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(visited[ny][nx]) continue;
				if(graph[ny][nx] != color) continue;

				visited[ny][nx] = true;
				q.add(new int[]{ny, nx});
				result++;
			}
		}

		return result * result;
	}

}
