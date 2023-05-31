import java.util.Scanner;

public class baek_1592_영식이와친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int humanCnt = sc.nextInt();
		int ballCnt = sc.nextInt();
		int Cnt = sc.nextInt();
		int[] human = new int[humanCnt];
		int count = 0;
		human[0] = 1;
		boolean flag = false;
		
		int hCnt = 0;
		while(flag==false) {
		for(int i=0; i<human.length; i++) {
			if(human[i]==ballCnt) flag=true;
		}
		if(flag==true)break;
		if(human[hCnt]%2!=0) {
			hCnt+=Cnt;
			if(hCnt>=humanCnt) hCnt%=humanCnt;
			human[hCnt]++;
			count++;
		}
		else if(human[hCnt]%2==0) {
			if(hCnt-Cnt<0) {
				int a = hCnt - Cnt;
				hCnt = humanCnt;
				hCnt -= Math.abs(a);
			}
			else if(hCnt-Cnt>=0) {
				Math.abs(hCnt-=Cnt);
			}
			human[hCnt]++;
			count++;
		}
		
		}
		System.out.println(count);
	}
}
