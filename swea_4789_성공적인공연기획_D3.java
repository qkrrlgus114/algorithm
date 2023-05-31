import java.util.Scanner;

public class swea_4789_성공적인공연기획_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			char[] clap = sc.next().toCharArray();
			int count = 0;
			int plus = 0;
			for(int i=0; i<clap.length; i++) {
				if(clap.length-1<=count) break;
				if(i!=0) {
					if(count<i&&clap[i]!='0') {
						plus += i-count;
						count+= i-count;
					}
				}
				count+=clap[i]-'0';
				
			}
			System.out.printf("#%d %d\n",q,plus);
		}
	}
}
