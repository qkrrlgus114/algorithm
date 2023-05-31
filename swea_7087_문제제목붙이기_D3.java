import java.util.Scanner;

public class swea_7087_문제제목붙이기_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			char al;
			int[] alpha = new int[26];
			for(int i=0; i<N; i++) {
				al = sc.next().charAt(0);
				alpha[al-'A']++;
			}
			int count = 0;
			for(int i=0; i<26; i++) {
				if(alpha[i] != 0 ) count++;
				else break;
			}
			System.out.printf("#%d %d\n",q,count);
		}
	}
}
