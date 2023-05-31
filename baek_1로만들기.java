import java.util.Arrays;
import java.util.Scanner;

public class baek_1로만들기 {
	static int[] arr;
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		arr = new int[num+1];
		arr[1]=0;
		if(num>3) {
			arr[2]=1;
			arr[3]=1;
		}else if(num==2) {
			arr[2]=1;
		}else if(num==3) {
			arr[2]=1;
			arr[3]=1;
		}
		
		if(num>3) {
			for(int i=4; i<=num; i++) {
				if(i%6==0) {
					arr[i]= Math.min(arr[i/2], Math.min(arr[i/3], arr[i-1]))+1;
				} else if(i%2==0) {
					arr[i]= Math.min(arr[i/2], arr[i-1])+1;
				} else if(i%3==0) {
					arr[i]= Math.min(arr[i/3], arr[i-1])+1;
				} else {
					arr[i] = arr[i-1]+1;
				}
			}
		}
		System.out.println(arr[num]);
	}
}
