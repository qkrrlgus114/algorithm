import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_11286_절댓값힙_실버1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// 앞에 절대값이 더 크다면
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				} else {
					return -1;
				}
			}
		});
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
