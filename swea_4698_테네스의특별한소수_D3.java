import java.util.Scanner;

public class swea_4698_테네스의특별한소수_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			char D = sc.next().charAt(0);
			int min = sc.nextInt();
			int max = sc.nextInt();
			int[] arr = new int[1000001];
			for(int i=2; i<=arr.length-1; i++) {
				arr[i] = i;
			}
			
			for(int i=2; i<=1000; i++) {
				if(arr[i] == 0) continue;
				
				for(int j=i*i; j<=max; j+=i) {
					arr[j] = 0;
				}
			}
			int count = 0;
			String num = null;
			for(int i=min; i<=max; i++) {
				if(arr[i]!=0) {
					num = Integer.toString(arr[i]);
					for(int j=0; j<num.length(); j++) {
						if(num.charAt(j)==D) {
							count++;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc,count);
		}
	}
}
