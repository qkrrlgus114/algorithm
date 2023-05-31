package 단계별문제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baek_1717_집합의표현_골드5 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] arr = new int [E][3];
		for(int i=0; i<E; i++) {
			arr[i][2] = sc.nextInt();
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
//		Arrays.sort(arr, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[2] - o2[2];
//			}
//		});
		
//		for(int[] ars : arr) {
//			System.out.println(Arrays.toString(ars));
//		}
		
		p = new int[V+1];
		for(int i=1; i<V+1; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			
			if(arr[i][2]==0) {
				union(x, y);
			}else if(arr[i][2]==1) {
				if(findset(x)!=findset(y)) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
			
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
