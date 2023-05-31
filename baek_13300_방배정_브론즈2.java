import java.util.Scanner;

public class baek_13300_방배정_브론즈2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] sex = new int[N];
		int[] grade = new int[N];
		// 입력을 받음.
		for (int i = 0; i < N; i++) {
			sex[i] = sc.nextInt();
			grade[i] = sc.nextInt();
		}

		int cnt = 0;
		int max = 1;
		boolean falg = false;
		for (int i = 0; i < N; i++) {
			for (int j = 1 + i; j < N; j++) {
				if(sex[i]!=7&&sex[i]==sex[j]&&grade[i]==grade[j]) {
					max++;
					sex[j] = 7;
					grade[j] = 7;
				}
			}
			if(sex[i]==7) continue;
			sex[i] = 7;
			grade[i] = 7;
			if(max>=K) {
				cnt = cnt+(max/K);
				if(max%K!=0) cnt++;
			} else if(max==1||max<K) cnt++;
			max=1;
		}
		System.out.println(cnt);

	}
}
