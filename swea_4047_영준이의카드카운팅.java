import java.util.Scanner;

public class swea_4047_영준이의카드카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int[] S = new int[13];
			int[] D = new int[13];
			int[] H = new int[13];
			int[] C = new int[13];
			String card = sc.next();
			int j = 0;
			for(int i=1; i<card.length(); i+=3) {
				if(card.charAt(i)=='0') {
					int a = card.charAt(i+1)-'0';
					if(card.charAt(j)=='S') S[a-1]++;
					else if(card.charAt(j)=='D') D[a-1]++;
					else if(card.charAt(j)=='H') H[a-1]++;
					else if(card.charAt(j)=='C') C[a-1]++;
					j+=3;
				}
				else {
					int a = card.charAt(i+1)-'0'+10;
						if(card.charAt(j)=='S') S[a-1]++;
						else if(card.charAt(j)=='D') D[a-1]++;
						else if(card.charAt(j)=='H') H[a-1]++;
						else if(card.charAt(j)=='C') C[a-1]++;
						j+=3;
					}
			}

			boolean flag = true;
			System.out.printf("#%d ",q);
			int[] output = new int[4];
			for(int i=0; i<4; i++) {
				int count = 0;
				for(int k=0; k<13; k++) {
					if(i==0) {
						if(S[k]==0) count++;
						else if(S[k]>1) flag = false;
					}
					else if(i==1) {
						if(D[k]==0) count++;
						else if(D[k]>1) flag = false;
					}
					else if(i==2) {
						if(H[k]==0) count++;
						else if(H[k]>1) flag = false;
					}
					else if(i==3) {
						if(C[k]==0) count++;
						else if(C[k]>1) flag = false;
					}
				}
				output[i] = count;
				if(flag==false) {
					System.out.print("ERROR");
					System.out.println();
					break;
				}
			}
			if(flag == false) continue;
			int w = 0;
			while(w!=4) {
				System.out.printf("%d ",output[w]);
				w++;
			}
			System.out.println();
		}
	}
}
