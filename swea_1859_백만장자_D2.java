import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class swea_1859_백만장자_D2 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			List<Integer> list = new ArrayList<Integer>();
			int N = sc.nextInt();
			long sum = 0;
			for(int i=0; i<N;  i++) {
				list.add(sc.nextInt());
			}
			long max = 0;
			for(int i=N-1; i>=0; i--) {
				if(max<list.get(i)) max=list.get(i);
				else if(max>list.get(i)) sum+=max-list.get(i);
			}
			System.out.printf("#%d %d\n",q,sum);
		}
	}
}
