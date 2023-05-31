import java.util.Scanner;

public class swea_9317_석찬이의받아쓰기_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			char[] correct = new char[N];
			char[] fail = new char[N];
			correct = sc.next().toCharArray();
			fail = sc.next().toCharArray();
			int count = 0;
			for(int i=0; i<N; i++) {
				if(correct[i] == fail[i]) count++;
			}
			System.out.printf("#%d %d\n",tc,count);
		}
	}
}
