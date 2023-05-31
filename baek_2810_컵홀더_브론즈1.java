import java.util.Scanner;

public class baek_2810_컵홀더_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seat = sc.next();
		int Scnt = 0;
		int Lcnt = 0;
		for(int i=0; i<seat.length(); i++) {
			if(seat.charAt(i)=='S') Scnt++;
			else Lcnt++;
		}
		if(N==1&&Scnt==1) {
			Scnt=2;
		} else if(N==1&&Lcnt==1) Lcnt=2;
		if(Lcnt!=0) {
			Lcnt = (Lcnt/2)+1;			
		}
		System.out.println(Lcnt+Scnt);
	}
}
