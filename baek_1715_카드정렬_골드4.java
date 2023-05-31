import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1715_카드정렬_골드4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			q.add(sc.nextInt());
		}
		int sumPoint = 0;
		while(q.size()!=1) {
			int sum = q.poll() + q.poll();
			sumPoint += sum;
			q.add(sum);
		}
		System.out.println(sumPoint);
	}
}
