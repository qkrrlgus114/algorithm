import java.util.Scanner;

public class swea_7272_안경이없어_D3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			char[] ch1 = sc.next().toCharArray();
			char[] ch2 = sc.next().toCharArray();
			int[] b1 = new int[ch1.length];
			int[] b2 = new int[ch2.length];
			char[] one = {'A','D','O','P','Q','R'};
			int count = 0;
			
			for(int i=0; i<ch1.length; i++) {
				for(int j=0; j<one.length; j++) {
					if(ch1[i]==one[j]) b1[i] = 1;
					else if(ch1[i]=='B') {
						b1[i] = 2;
					}
				}
			}
			
			for(int i=0; i<ch2.length; i++) {
				for(int j=0; j<one.length; j++) {
					if(ch2[i]==one[j]) b2[i] = 1;
					else if(ch2[i]=='B') {
						b2[i] = 2;
					}
				}
			}
			if(b1.length==b2.length) {
				for(int i=0; i<b1.length; i++) {
					if(b1[i]==b2[i]) count++;
				}
			}
			
			if(b1.length==b2.length&&count==b1.length) System.out.printf("#%d SAME\n",q);
			else System.out.printf("#%d DIFF\n",q);
			
		}
	}
}