import java.util.Scanner;

public class baek_1213_팰린드롬만들기_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] name = new char[str.length()];
		int[] count = new int[26];
		boolean flag = true;
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-'A']++;
		}
		int last = str.length()-1;
		if(str.length()%2==0) {
			for(int i=0; i<str.length()/2; i++) {
				for(int j=0; j<26; j++) {
					if((count[j]>2&&count[j]!=0)||(count[j]%2==0&&count[j]!=0)) {
						name[i] = (char) (j+'A');
						name[last] = (char) (j+'A');
						count[j]-=2;
						last--;
						break;
					}
				}
			}
		} else {
			for(int i=0; i<(str.length()/2)+1; i++) {
				for(int j=0; j<26; j++) {
					if((count[j]>2&&count[j]!=0)||(count[j]%2==0&&count[j]!=0)) {
						name[i] = (char) (j+'A');
						name[last] = (char) (j+'A');
						count[j]-=2;
						last--;
						break;
					} else if(i==(str.length()/2)&&count[j]==1) {
						name[i] = (char) (j+'A');
					}
				}
			}
		}
		for(int i=0; i<name.length; i++) {
			if(name[i] == '\u0000') {
				System.out.println("I'm Sorry Hansoo");
				flag = false;
				break;
			}
		}
		
		if(flag == true) {
			for(int i=0; i<name.length; i++) {
				System.out.print(name[i]);
			}
		}
		
		
	}
}
