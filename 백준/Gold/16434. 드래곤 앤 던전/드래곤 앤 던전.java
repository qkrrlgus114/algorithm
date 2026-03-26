import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");

		int N = Integer.parseInt(sa[0]);
		int H = Integer.parseInt(sa[1]);

		List<Stage> stages = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			sa = bf.readLine().split(" ");
			stages.add(new Stage(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
		}

		long answer = Long.MAX_VALUE;
		long s = 1;
		long e = Long.MAX_VALUE;

		while (s <= e) {
			long m = (s + e) / 2;
			long curHealth = m;
			long curAttack = H;
			boolean fail = false;

			for (int i = 0; i < stages.size(); i++) {
				Stage stage = stages.get(i);
				long monsterHealth = stage.health;

				if (stage.value == 1) {
					long loop = (monsterHealth - 1) / curAttack;
					if (stage.attack * loop >= curHealth) {
						fail = true;
						break;
					}

					curHealth -= (stage.attack * loop);
				} else {
					if (curHealth + stage.health >= m) {
						curHealth = m;
					} else {
						curHealth += stage.health;
					}
					curAttack += stage.attack;
				}
			}

			if (!fail) {
				answer = Math.min(m, answer);
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		System.out.println(answer);

	}
}

class Stage {
	long value;
	long attack;
	long health;

	public Stage(long value, long attack, long health) {
		this.value = value;
		this.attack = attack;
		this.health = health;
	}
}