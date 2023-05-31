import java.util.Scanner;

public class swea_4406_모음이보이지않는사람_D3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean flag = true;
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			char[] mo = {'a','e','i','o','u'};
			char[] word = sc.next().toCharArray();
			for(int i=0; i<word.length; i++) {
				flag = true;
				for(int j=0; j<mo.length; j++) {
					if(word[i]==mo[j]) {
						flag = false;
						break;
					}
				}
				if(flag==true) sb.append(word[i]);
			}
			System.out.printf("#%d %s\n",tc,sb.toString());
		}
	}
}