import java.util.Scanner;

public class baek_25206_너의평점은_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] grade = { "A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P" };
		double[] gradepoint = { 4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
		double sum = 0;
		int idx = 0;
		double gradep = 0;
		for (int tc = 0; tc < 20; tc++) {
				sc.next();
				double point = sc.nextDouble();
				String mygrade = sc.next();
				if(mygrade.equals("P")) {
					continue;
				}
				for(int j=0; j<grade.length; j++) {
					if(grade[j].equals(mygrade)) {
						idx = j;
						break;
					}
				}
				sum += point*gradepoint[idx];
				gradep += point;
		}
			System.out.printf("%f",sum/gradep);			
	}
}
