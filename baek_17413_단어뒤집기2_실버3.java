import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baek_17413_단어뒤집기2_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		char[] word = sc.nextLine().toCharArray();
		char[] reword = new char[word.length];
		int cnt = 0;
		int snt = 0;
		for(int i=0; i<word.length; i++) {
			cnt = i;
			if(word[i]=='<'||word[i]==' ') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
							reword[snt++] = stack.pop();					
					}
				}
				if(word[i]=='<') {
					while(true) {
						if(word[cnt]!='>') {
							reword[snt++] = word[cnt++];							
						}else {
							reword[snt++] = word[cnt++];
							break;
						}
						
					} i=cnt-1;
				} else if(word[i]==' ') {
					reword[snt++] = word[cnt++];
				}
			}else if(word[i]!=' '&&word[i]!='<') {
				stack.add(word[i]);
			}
			if(i==word.length-1) {
				while(!stack.isEmpty()) {
					reword[snt++] = stack.pop();
				}
			}
		}
		for(int i=0; i<word.length; i++) {
			System.out.print(reword[i]);
		}
	}
}
