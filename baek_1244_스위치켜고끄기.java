import java.util.Arrays;
import java.util.Scanner;

public class baek_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Swcount = sc.nextInt();
		int[] Sw = new int[Swcount];
		for(int i=0; i<Sw.length; i++) {
			Sw[i] = sc.nextInt();
		}
		int humanCount = sc.nextInt();
		for(int i=0; i<humanCount; i++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			if(sex==1) {
				for(int j=0; j<Sw.length; j++) {
					if((j+1)%num==0) {
						if(Sw[j]==1) Sw[j]=0;
						else Sw[j]=1;
					}
				}
			}
			else if(sex==2) {
				int count = 0;
				for(int j=1; j<Sw.length; j++) {
					if(num-1+j<Sw.length&&num-1-j>=0&&(Sw[num-1+j] == Sw[num-1-j])) {
						count++;
						continue;
					}
					else break;
				}
				for(int j=0; j<=count; j++) {
					if(Sw[num-1+j]==0&&Sw[num-1-j]==0) {
						Sw[num-1+j]=1;
						Sw[num-1-j]=1;
					}
					else if(Sw[num-1+j]==1&&Sw[num-1-j]==1) {
						Sw[num-1+j]=0;
						Sw[num-1-j]=0;
					}
					}
				}
			}
		for(int i=0; i<Sw.length; i++) {
			if(i!=0&&i%20==0) {
				System.out.println();
			}
			System.out.print(Sw[i]+" ");
			
		}
		}
	}

