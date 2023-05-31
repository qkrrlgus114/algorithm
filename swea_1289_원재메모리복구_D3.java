import java.util.Scanner;

public class swea_1289_원재메모리복구_D3 {
	public static char[] def;
	public static int cnt;
	public static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			def = sc.next().toCharArray();
			cal(def);
			System.out.printf("#%d %d\n",tc,cnt);
			
		}
		
	}

	// 판단하는 메서드
	public static void cal(char[] def) {
		cnt = 0;
		int num = 0; 
		for(int i=0; i<def.length; i++) {
			if(def[i]=='1'&&num==0) {
				num=1;
				cnt++;
			}
			else if(def[i]=='0'&&num==1) {
				num=0;
				cnt++;
			}
		}
	}
}