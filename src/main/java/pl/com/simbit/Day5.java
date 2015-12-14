package pl.com.simbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 implements Day {

	public String getAnswer1() {
		List<String> readProblemLines = FileReader.readProblemLines(5);

		int nice = 0;

		for (String s : readProblemLines) {
			boolean inc = false;
			boolean same = false;
			int vov = 0;
			if (isVovel(s.charAt(0))) {
				vov++;
			}
			for (int i = 0; i < s.length() - 1; i++) {
				char c1 = s.charAt(i);
				char c2 = s.charAt(i + 1);
				if (isIncorrect(c1, c2)) {
					inc = true;
					break;
				}
				if (vov < 3 && isVovel(c2)) {
					vov++;
				}
				if (!same && isSame(c1, c2)) {
					same = true;
				}
			}
			if (vov == 3 && same && !inc)
				nice++;

		}
		return nice + "";
	}

	boolean isVovel(char c) {
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		}
		return false;
	}

	boolean isIncorrect(char c1, char c2) {
		if (c1 == 'a' && c2 == 'b') {
			return true;
		}
		if (c1 == 'c' && c2 == 'd') {
			return true;
		}
		if (c1 == 'p' && c2 == 'q') {
			return true;
		}
		if (c1 == 'x' && c2 == 'y') {
			return true;
		}
		return false;
	}

	boolean isSame(char c1, char c2) {
		return c1 == c2;
	}

	public String getAnswer2() {
		List<String> readProblemLines = FileReader.readProblemLines(5);

		int nice = 0;

		Map<String, Integer> map;

		for (String s : readProblemLines) {
			boolean inc = false;
			boolean same = false;

			map = new HashMap<>();
			map.put("" + s.charAt(0) + s.charAt(1), 0);

			String sa = "";
			char cc = 'ą';

			for (int i = 0; i < s.length() - 2; i++) {
				char c1 = s.charAt(i);
				char c2 = s.charAt(i + 1);
				char c3 = s.charAt(i + 2);
				String key = "" + c2 + c3;
				if (!inc && map.get(key) != null && i + 1 - map.get(key) > 1) {
					inc = true;
					sa = key;
				} else {
					if (map.get(key) == null) {
						map.put(key, i + 1);
					}
				}
				if (!same && isSame(c1, c3)) {
					cc = c1;
					same = true;
				}
			}
			if (same && inc) {
				nice++;
				System.out.println("OK STRING: " + s + " -- KEY: " + sa + " -- CC: " + cc);
			}

		}
		return nice + "";
	}

}
