import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1927_최소힙_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				if (pq1.size() == 0) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq1.poll()).append("\n");
				}
			} else if (x != 0) {
				pq1.add(x);
			}
		}
		System.out.println(sb);
	}
}
