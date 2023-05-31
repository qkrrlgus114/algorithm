import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baek_18310_안테나_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		if(N%2==0) { // 짝수면 (N/2)-1 인덱스가 정답
			System.out.println(list.get((N/2)-1));
		}else { // 홀수면 N/2 인덱스가 정답.
			System.out.println(list.get(N/2));
		}
	}
}
