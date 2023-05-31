import java.util.Scanner;

public class baek_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int five = 0;
		int sugar = sc.nextInt();
		if(sugar%5==0) count = sugar/5;
		else if(sugar>5){
			five = sugar/5;
			sugar = sugar%5; 
			while(true) {
				if(sugar%3==0) {
					count = five + (sugar/3);
					break;
				}
				else if(five==0) {
					count=-1;
					break;
				}
				else {
					five--;
					sugar+=5;
				}
			}
		}
		else if(sugar==3) count=1;
		else count = -1;
		System.out.println(count);
	}
}
