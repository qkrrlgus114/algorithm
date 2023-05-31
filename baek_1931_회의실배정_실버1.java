import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baek_1931_회의실배정_실버1 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] talk = new int[100001][2];
		
		for(int i=0; i<N; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			talk[i][0] = st;
			talk[i][1] = ed;
		}
		Arrays.sort(talk, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.
			}
		});
		
		
		
	}

}
