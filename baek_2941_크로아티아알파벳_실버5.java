import java.util.Scanner;

public class baek_2941_크로아티아알파벳_실버5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alpha = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		int two = 0;
		int three = 0;
		for(int i=0; i<str.length()-1; i++) {
			sb.append(str.charAt(i)).append(str.charAt(i+1));
			for(int j=0; j<8; j++) {
				if(alpha[j].equals(sb.toString())) {
					two++;
				}
			}
			sb.setLength(0);
		}
		for(int i=0; i<str.length()-2; i++) {
			for(int j=0; j<8; j++) {
				sb.append(str.charAt(i)).append(str.charAt(i+1)).append(str.charAt(i+2));
				if(alpha[j].equals(sb.toString())) {
					three++;
				}
				sb.setLength(0);
			}
		}
		int num = str.length();
		num = num - two-three;
		System.out.println(num);
	}
}