import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class swea_제로_직접구현함 {
	static int top = -1;
	static int[] stack = new int[100000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			int K = sc.nextInt();
			
			for(int i=0; i<K; i++) {
				int num = sc.nextInt();
				if(num!=0) {
					push(num);
				}
				else {
					pop();
				}
			}
			int sum = 0;
			while(top!=-1) {
				int x = pop();
				sum += x;
			}
			System.out.printf("#%d %d\n",k,sum);
		}
		
	}
	
	public static void push(int x) {
		if(top==stack.length-1) {
		}
		else {
			top++;
			stack[top] = x;
		}
	}
	
	public static int pop() {
		if(top==-1) {
			return -1;
		}
		else {
			return stack[top--];
		}
	}
}
