import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 상근이유니온 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] arr = new int[E][2];
			for(int i=0; i<E; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			p = new int[V+1];
			for(int i=1; i<V+1; i++) {
				p[i] = i;
			}
			
			int pick = 1;
			
			for(int i=0; i<E; i++) {
				int x = arr[i][0];
				int y = arr[i][1];
				
				if(findset(x)!=findset(y)) {
					union(x, y);
					pick++;
				}
				if(pick == V-1) break;
			}
			int max = 0;
			for(int i=0; i<V+1; i++) {
				if(max < p[i]) max = p[i];
			}
			System.out.println(Arrays.toString(p));
			System.out.println(max-1);
		}
	}
	
	public static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
