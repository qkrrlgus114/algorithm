import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_8673_코딩토너먼트_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean flag = false;
		for(int qc=1; qc<=T; qc++) {
			flag = false;
			Queue<Integer> q = new LinkedList<>();
			int K = sc.nextInt();
			for(int i=0; i<Math.pow(2, K); i++) {
				q.add(sc.nextInt());
			}
			int sum = 0;
			while(flag==false) {
				int a = q.poll();
				int b = q.poll();
				sum += Math.abs(a-b);
				q.add(Math.max(a, b));
				if(q.size()==1) flag=true;
			}
			System.out.printf("#%d %d\n", qc, sum);
		}
	}
}
