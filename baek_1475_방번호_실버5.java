import java.util.Scanner;

public class baek_1475_방번호_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] num = str.toCharArray();
		int[] count = new int[9];
		for(int i=0; i<num.length; i++) {
			if(num[i]-'0'==6||num[i]-'0'==9) {
				count[6]++;
			}else {
				count[num[i]-'0']++;				
			}
		}
		if(count[6]%2==0) {
			count[6]/=2;
		}else {
			count[6] = (count[6]/2)+1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<9; i++) {
			if(max<count[i]) max = count[i];
		}
		System.out.println(max);
		
	}
}
