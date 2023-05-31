import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class baek_1946_신입사원_실버1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] num = new int[N][2];
			for (int i = 0; i < N; i++) {
				num[i][0] = sc.nextInt();
				num[i][1] = sc.nextInt();
			}
			Arrays.sort(num, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0] - o2[0];
				}

			});
			int max = num[0][1];
			int count = 1;
			for(int i=1; i<N; i++) {
				if(num[i][1]<max) {
					max = num[i][1];
					count++;
				}
			}
			System.out.println(count);
			
		}
	}
}
