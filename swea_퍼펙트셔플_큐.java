import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_퍼펙트셔플_큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			if(N%2==0) {
				for(int i=0; i<N/2; i++) {
					q1.offer(sc.next());
				}
				for(int i=0; i<N/2; i++) {
					q2.offer(sc.next());
				}
				System.out.printf("#%d ",q);
				for(int i=0; i<N/2; i++) {
					System.out.printf("%s ",q1.remove());
					System.out.printf("%s ",q2.remove());	
				}
			}
			else {
				for(int i=0; i<N/2+1; i++) {
					q1.offer(sc.next());
				}
				for(int i=0; i<N/2; i++) {
					q2.offer(sc.next());
				}
				System.out.printf("#%d ",q);
				for(int i=0; i<N/2; i++) {
					System.out.printf("%s ",q1.remove());
					System.out.printf("%s ",q2.remove());
				}
				System.out.printf("%s ",q1.remove());
			}
			System.out.println();
			
			
		}
		
		
	}
}
