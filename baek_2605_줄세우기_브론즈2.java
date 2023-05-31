import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class baek_2605_줄세우기_브론즈2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		List<Integer> list = new LinkedList<>();
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			list.add(s, cnt++);
		}
		for(int i=N-1; i>=0; i--) {
			System.out.print(list.get(i)+" ");
		}
	}
}