import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class baek_11866_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int temp = 0;
		String output = "<";
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			for(int j=0; j<K-1; j++) {
				temp = q.remove();
				q.add(temp);
			}
			if(q.size()==1) output += q.remove()+">";
			else output += q.remove()+", ";
		}
		System.out.println(output);
	}
}
