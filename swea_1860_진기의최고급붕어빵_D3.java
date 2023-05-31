import java.util.Arrays;
import java.util.Scanner;

public class swea_1860_진기의최고급붕어빵_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			int second = sc.nextInt();
			int fishbbang = sc.nextInt();
			int[] human = new int[N];
			int count = 0;
			int waiting = 0;
			boolean flag = true;
			// 사람의 초를 입력받아 배열에 넣음
			for(int i=0; i<human.length; i++) {
				human[i] = sc.nextInt();
			}
			Arrays.sort(human);
			int max = human[human.length-1];
			for(int i=0; i<=max; i++) {
				if(i%second==0&&i!=0) {
					count+=fishbbang;
				}
				if(i==human[waiting]) {
					if(human[waiting]>=second&&count!=0) {
						count--;
						if(waiting<N-1) waiting++;
						else break;
					} else {
						flag = false;
						break;
					}
				}
			}
			if(flag==false) System.out.printf("#%d Impossible\n",q);
			else System.out.printf("#%d Possible\n",q);
		}
	}
}

