import java.util.Scanner;

public class baek_14696_딱지놀이_브론즈1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int tc=0; tc<N; tc++) {
			boolean Awin = false;
			boolean Bwin = false;
			int A = sc.nextInt();
			int[] Acard = new int[5];
			for(int i=0; i<A; i++) {
				Acard[sc.nextInt()]++;
			}
			int B = sc.nextInt();
			int[] Bcard = new int[5];
			for(int i=0; i<B; i++) {
				Bcard[sc.nextInt()]++;
			}
			for(int i=4; i>=1; i--) {
				if(Acard[i]>Bcard[i]) {
					Awin = true;
					break;
				} else if(Acard[i]<Bcard[i]) {
					Bwin = true;
					break;
				}
			}
			if(Awin==true) {
				System.out.println("A");
			} else if(Bwin==true) {
				System.out.println("B");
			} else {
				System.out.println("D");
			}
		}
	}
}