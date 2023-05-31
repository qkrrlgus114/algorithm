import java.util.Arrays;
import java.util.Scanner;

public class swea_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int q = 1; q <= T; q++) {
			int N = sc.nextInt();
			// 값을 받을 스트링 배열
			String[] card = new String[N];
			// 바뀐 값을 넣을 스트링 배열
			String[] newcard = new String[N];
			// 값 넣기
			for (int i = 0; i < card.length; i++) {
				card[i] = sc.next();
				newcard[i] = "";
			}
			int count = 0;
			// 절반 나눠서 보니깐 2번만 반복
			for (int i = 0; i < 2; i++) {
				// j에 2씩 더해주면서 끼워넣기.
				for (int j = 0 + i; j < newcard.length; j += 2) {
					newcard[j] = card[count++];
				}
			}
			
			System.out.printf("#%d ",q);
			for(int i=0; i<newcard.length; i++) {
				System.out.printf("%s ",newcard[i]);
			}
			System.out.println();

		}
	}
}
