import java.util.Scanner;

public class baek_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt()+1;
		int S = sc.nextInt()+1;
		int[][] map = new int[S][G];
		int market = sc.nextInt();
		int count = 1;
		for(int l=0; l<=market; l++) {
			int mG = sc.nextInt();
			int mS = sc.nextInt();
			if(l == market) {
				if(mG==1) map[0][mS] = 111;
				else if(mG==2) map[S-1][mS] = 111;
				else if(mG==3) map[mS][0] = 111;
				else if(mG==4) map[mS][G-1] = 111;
			}
			else {
				if(mG==1) map[0][mS] = count++;
				else if(mG==2) map[S-1][mS] = count++;
				else if(mG==3) map[mS][0] = count++;	
				else if(mG==4) map[mS][G-1] = count++;
			}
		}
		
		int realsum = 0;
		int sum = 0;
		for(int l=1; l<count; l++) {
			int mi = 0;
			int mj = 0;
			int di = 0;
			int dj = 0;
			for(int i=0; i<S; i++) {
				for(int j=0; j<G; j++) {
					if(map[i][j]==l) {
						mi = i;
						mj = j;
					}
					else if(map[i][j]==111) {
						di = i;
						dj = j;
					}
				}
			}
			// 왼쪽
			while(true){
				if((mi==0 && di==S-1)||(di==0 && mi==S-1)||(dj==0&&mj==G-1)||(mj==0&&dj==G-1)) {
					int a = di+mi+dj+mj;
					int b = (((G-1)*2)+((S-1)*2))-a;
					if(a<b) sum+=a;
					else if(a>=b) sum+=b;
				}
				else if(di<=mi) {
					sum+=mi-di;
					if(dj<mj) sum+=mj-dj;
					else if(mj<dj) sum+=dj-mj;
				}
				else if(mi<=di) {
					sum+=di-mi;
					if(dj<mj) sum+=mj-dj;
					else if(mj<dj) sum+=dj-mj;
				}
				System.out.println(sum);
				break;
			}
			
		}
		System.out.println(sum);


		
		
		
		
//		for(int i=0; i<map.length; i++) {
//			for(int j=0; j<G; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}
