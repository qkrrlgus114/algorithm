import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1158_요세푸스_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 인원
		int K = sc.nextInt()-1; // 제거하는 사람의 순서
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while (q.size() != 0) {
			if (q.size() == 1) {
				sb.append(q.poll() + ">");
			} else if (K == 0) {
				while (q.size() != 0) {
					if (q.size() > 1) {
						sb.append(q.poll() + ", ");
					} else if(q.size()==1){
						sb.append(q.poll() + ">");
					}
				}
			} else {
				for (int i = 0; i < K; i++) {
					q.add(q.poll());
					if (i == K - 1) {
						sb.append(q.poll() + ", ");
					}
				}
			}
		}
		System.out.println(sb);
	}
}
