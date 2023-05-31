import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_18111_마인크래프트_실버2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max<map[i][j]) max = map[i][j];
				if(min>map[i][j]) min = map[i][j];
			}
		}
		int mintime = Integer.MAX_VALUE;
		int maxheight = Integer.MIN_VALUE;
		int cnt = 0;
		int item = 0;
		for(int q=min; q<=max; q++) {
			cnt = 0;
			item = B;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]>q) { // 블록을 제거해야함.
						cnt += (map[i][j] - q)*2;
						item += map[i][j] - q;
					} else if(map[i][j]<q) { // 블록을 추가해야함.
						cnt += Math.abs(map[i][j] - q);
						item -= Math.abs(map[i][j] - q);
					}
				}
			}
			if(item<0) break;
			if(item>=0&&mintime>=cnt&&maxheight<q) {
				mintime = cnt;
				maxheight = q;
			}
		}
		System.out.print(mintime+" ");
		System.out.println(maxheight);
		
		
	}
}
