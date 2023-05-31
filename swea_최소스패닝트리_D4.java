import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class swea_최소스패닝트리_D4 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] arr = new int [E][3];
			for(int i=0; i<E; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}
			p = new int[V+1];
			for(int i=1; i<V+1; i++) {
				p[i] = i;
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			int ans = 0;
			int pick = 0;
			for(int i=0; i<E; i++) {
				int x = arr[i][0];
				int y = arr[i][1];
				
				if(findset(x)!=findset(y)) {
					union(x, y);
					ans += arr[i][2];
					pick++;
				} 
				if(pick==V-1) break;
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	
	public static int findset(int x) {
		if(x!=p[x]) p[x] = findset(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
