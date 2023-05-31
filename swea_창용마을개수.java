import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class swea_창용마을개수 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] count = new int[V+1];
			if(E==0) {
				System.out.printf("#%d %d\n",tc,1);
				continue;
			}
			
			int[][] arr = new int[E][2];
			for (int i = 0; i <E; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();

			}

			p = new int[V+1];

			for (int i = 1; i <= V; i++) {
				p[i] = i;
			}
			int cnt = 0;
			int pick = 0;
			for (int i = 0; i < E; i++) {
				int x = arr[i][0];
				int y = arr[i][1];
				if (findset(x) != findset(y)) {
					union(x, y);
					pick++;
				}
				if (pick == V - 1) {
					break;
				}
			}
			for(int i=0; i<E; i++) {
				int x = arr[i][0];
				int y = arr[i][1];
				if(findset(x) == findset(y)) {
					cnt++;
				}
			}
			for(int i=1; i<=V; i++) {
				if(p[i]!=0) count[p[i]]++;
			}
			cnt = 0;
			for(int i=1; i<=V; i++) {
				if(count[i] != 0) cnt++;
			}
			System.out.printf("#%d %d\n",tc,cnt);
//			for (int q = 0; q < E; q++) {
//				int w = arr[q][0];
//				int e = arr[q][1];
//				int a = findset(w);
//				int b = findset(e);
//				count[a]++;
//				count[b]++;
//			}
//			int cntt = 0;
//			for(int i=0; i<101; i++) {
//				if(count[i]!=0) {
//					cntt++;
//				}
//			}
//			System.out.printf("#%d %d\n",tc,cntt);
		}
	}

	public static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
