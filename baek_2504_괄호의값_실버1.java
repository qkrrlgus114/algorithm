import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Soundbank;

public class baek_2504_괄호의값_실버1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] num = str.toCharArray();
		int sum = 0;
		int[] list = new int[15];
		int cnt = 0;
		boolean flag = true;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		for(int i=0; i<num.length; i++) {
			boolean a = true;
			sum = 0;
			if(num[i]=='(') {
				if(i!=0&&num[i-1]==')') {
					if(!s1.isEmpty()) {
						stack.add(num[i]);
						s3.add(s1.pop());
					}
				}else {
					stack.add(num[i]);					
				}
			} else if(num[i]=='[') {
				if(i!=0&&num[i-1]==']') {
					if(!s2.isEmpty()) {
						s3.add(s2.pop());
						stack.add(num[i]);
					}
				}else {
					stack.add(num[i]);					
				}
			} else if(i==0&&(num[i]==')'||num[i]==']')) {
				flag = false;
				break;
			} else if(num[i]==')') {
				if(!stack.isEmpty()&&stack.peek()=='(') {
					stack.pop();
					if(stack.isEmpty()) {
						if(!s1.isEmpty()) {
							sum+=s1.pop();							
						}
						if(!s2.isEmpty()) {
							sum+=s2.pop();							
						}
						if(!s3.isEmpty()) {
							while(!s3.isEmpty()) {
								sum+=s3.pop();
							}
						}
						if(sum==0) {
							a = false;
							sum=2;
						}
						if(sum==2&&a==false) {
							list[cnt++] = sum;
						} else {
							list[cnt++] = sum*2; 							
						}
					}
					else if(!s1.isEmpty()) {
						s1.add(s1.pop()*2);
					}
					else if(s1.isEmpty()&&num[i-1]==']') {
						s1.add(s2.pop()*2);
					}
					else if(s1.isEmpty()){
							s1.add(2);							
					}
				} else if(!stack.isEmpty()&&stack.peek()=='[') {
					flag = false;
					break;
				} else if(stack.isEmpty()) {
					flag = false;
					break;
				}
			} else if(num[i]==']') {
				if(!stack.isEmpty()&&stack.peek()=='[') {
					stack.pop();
					if(stack.isEmpty()) {
						if(!s1.isEmpty()) {
							sum+=s1.pop();							
						}
						if(!s2.isEmpty()) {
							sum+=s2.pop();							
						}
						if(sum==0) {
							a=false;
							sum=3;
						}
						if(sum==3&&a==false) {
							list[cnt++] = sum;
						} else {
							list[cnt++] = sum*3; 							
						}
					}
					else if(!s2.isEmpty()) {
						s2.add(s2.pop()*3);
					} 
					else if(s1.isEmpty()&&num[i-1]==')') {
						s2.add(s1.pop()*3);
					}
					else if(s2.isEmpty()){
						s2.add(3);
					}

				} else if(!stack.isEmpty()&&stack.peek()=='(') {
					flag = false;
					break;
				} else if(stack.isEmpty()) {
					flag = false;
					break;
				}
			}
			System.out.println(Arrays.toString(list));
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
		}else {
			sum = 0;
			for(int i=0; i<15; i++) {
				sum+=list[i];
			}
			if(flag==true) {
				System.out.println(sum);			
			} else {
				System.out.println(0);
			}

			
		}
	}
}
