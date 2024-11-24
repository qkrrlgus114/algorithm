import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int G = Integer.parseInt(bf.readLine());

		List<Integer> list = new ArrayList<>();

		int p1 = 1;
		int p2 = 1;

		while (p1 <= G && p2 <= G) {
			int value = (p1 * p1) - (p2 * p2);

			if (value == G) {
				list.add(p1);
				p1++;
			} else if (value < G) {
				p1++;
			} else {
				p2++;
			}
		}

		StringBuilder sb = new StringBuilder();
		if (list.isEmpty())
			System.out.println(-1);
		else {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append("\n");
			}
			System.out.println(sb);
		}
	}

}