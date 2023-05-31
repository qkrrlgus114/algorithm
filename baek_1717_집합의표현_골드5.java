import java.util.Scanner;

public class baek_1717_집합의표현_골드5 {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] arr = new int[E][3];

		for (int i = 0; i < E; i++) {
			arr[i][2] = sc.nextInt(); // 0,1
			arr[i][0] = sc.nextInt(); // 시작점
			arr[i][1] = sc.nextInt(); // 끝점
		}
		p = new int[V + 1];
		// makeSet
		for (int i = 1; i < V + 1; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			if(arr[i][2]==0) {
				union(arr[i][0], arr[i][1]);
			}else if(arr[i][2]==1) {
				if(findset(arr[i][0])==findset(arr[i][1])) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

	public static int findset(int x) {
		if (p[x] != x)
			p[x] = findset(p[x]);
		return p[x];
	}

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
