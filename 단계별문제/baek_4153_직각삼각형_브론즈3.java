package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_4153_직각삼각형_브론즈3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {
			int[] arr = new int[3];
			for(int i=0; i<3; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			if (arr[0] != 0 && arr[1] != 0 && arr[2] != 0) {
				if (Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}else {
				flag = false;				
			}
		}
	}
}
