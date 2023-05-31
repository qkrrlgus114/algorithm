import java.util.Scanner;

public class baek_5635_생일_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] name = new String[N];
		int[] day = new int[N];
		int[] month = new int[N];
		int[] year = new int[N];
		for(int i=0; i<N; i++) {
			name[i] = sc.next();
			day[i] = sc.nextInt();
			month[i] = sc.nextInt();
			year[i] = sc.nextInt();
		}
		int yIdx = 0;
		int oIdx = 0;
		for(int i=0; i<N; i++) {
			if(year[yIdx]<year[i]) {
				yIdx = i;
			} else if(year[yIdx]==year[i]) {
				if(month[yIdx]<month[i]) {
					yIdx = i;
				} else if(month[yIdx]==month[i]) {
					if(day[yIdx]<day[i]) {
						yIdx = i;
					} else {
						continue;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(year[oIdx]>year[i]) {
				oIdx = i;
			} else if(year[oIdx]==year[i]) {
				if(month[oIdx]>month[i]) {
					oIdx = i;
				} else if(month[oIdx]==month[i]) {
					if(day[oIdx]>day[i]) {
						oIdx = i;
					} else {
						continue;
					}
				}
			}
		}
		System.out.println(name[yIdx]);
		System.out.println(name[oIdx]);
	}
}
