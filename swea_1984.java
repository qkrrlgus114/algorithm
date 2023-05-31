import java.util.Scanner;

public class swea_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 1; k <= T; k++) {
			int[] num = new int[10];
			//입력 값 배열에 넣기
			for(int i=0; i<num.length; i++) {
				num[i] = sc.nextInt();
			}
			//버블 정렬 사용
			for(int j=0; j<num.length; j++) {
				for(int i=0; i<num.length-1-j; i++) {
					if(num[i] > num[i+1]) {
						int temp = num[i];
						num[i] = num[i+1];
						num[i+1] = temp;
					}
				}	
			}
//			System.out.println(Arrays.toString(num));
			//최대, 최소 제외하기 위해서 i=1부터 i<num.length-1까지 동작
			int sum = 0;
			for(int i=1; i<num.length-1; i++) {
				sum += num[i];
			}
			//평균 계산
			double avr = sum/8.0;
			avr = Math.round(avr);

			System.out.printf("#%d %.0f\n",k,avr);
		}
	}
}
