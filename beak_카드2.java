import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class beak_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<Integer>();
		int N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		while(q.size()!=1) {
			q.remove();
			q.add(q.remove());
		}
		
		System.out.println(q.peek());
	}
}
