
public class baek_4673_셀프넘버_실버5 {
	static int[] count = new int[20000];
	
	public static void main(String[] args) {
		for(int i=1; i<10001; i++) {
			count[i] = i;
		}
		self(1);
		
	}
	// 셀프넘버 구하는 메서드
	public static void self(int x) {
		while(x!=10001) {
			if(x<10) {
				int sum = x+x;
				count[sum] = 0;
			} else {
				int sum = x;
				int num = x;
				int namer = 0;
				while(num>=1) {
					namer = num%10;
					sum += namer;
					num = num/10;
				}
				count[sum] = 0;
			}
			x++;
		}
		for(int i=1; i<10001; i++) {
			if(count[i]!=0) System.out.println(count[i]);
		}
		
	}
}
