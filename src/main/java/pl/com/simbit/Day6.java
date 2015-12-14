package pl.com.simbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 implements Day {

	public String getAnswer1() {
		List<String> readProblemLines = FileReader.readProblemLines(6);

		boolean[][] tab = new boolean[1000][1000];

		for (String s : readProblemLines) {
			String[] split = s.split(" through ");

			if (s.startsWith("turn on")) {
				split[0] = split[0].substring(8, split[0].length());
				int[] ii = sp(split);
				on(tab, ii[0], ii[1], ii[2], ii[3]);
			}
			if (s.startsWith("turn off")) {
				split[0] = split[0].substring(9, split[0].length());
				int[] ii = sp(split);
				off(tab, ii[0], ii[1], ii[2], ii[3]);
			}
			if (s.startsWith("toggle")) {
				split[0] = split[0].substring(7, split[0].length());
				int[] ii = sp(split);
				tog(tab, ii[0], ii[1], ii[2], ii[3]);
			}
		}
		int on = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (tab[i][j]) {
					on++;
				}
			}
		}
		return on + "";
	}

	private int[] sp(String[] split) {
		String[] s0 = split[0].split(",");
		String[] s1 = split[1].split(",");
		return new int[] { Integer.parseInt(s0[0]), Integer.parseInt(s1[0]), Integer.parseInt(s0[1]),
				Integer.parseInt(s1[1]) };
	}

	void tog(boolean[][] tab, int x1, int x2, int y1, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				tab[i][j] = !tab[i][j];
			}
		}
	}

	void off(boolean[][] tab, int x1, int x2, int y1, int y2) {

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				tab[i][j] = false;
			}
		}
	}

	void on(boolean[][] tab, int x1, int x2, int y1, int y2) {

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				tab[i][j] = true;
			}
		}
	}

	public String getAnswer2() {
		List<String> readProblemLines = FileReader.readProblemLines(6);

		int[][] tab = new int[1000][1000];

		for (String s : readProblemLines) {
			String[] split = s.split(" through ");

			if (s.startsWith("turn on")) {
				split[0] = split[0].substring(8, split[0].length());
				int[] ii = sp(split);
				on2(tab, ii[0], ii[1], ii[2], ii[3]);
			}
			if (s.startsWith("turn off")) {
				split[0] = split[0].substring(9, split[0].length());
				int[] ii = sp(split);
				off2(tab, ii[0], ii[1], ii[2], ii[3]);
			}
			if (s.startsWith("toggle")) {
				split[0] = split[0].substring(7, split[0].length());
				int[] ii = sp(split);
				tog2(tab, ii[0], ii[1], ii[2], ii[3]);
			}
		}
		int on = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				on += tab[i][j];
			}
		}
		return on + "";
	}

	void tog2(int[][] tab, int x1, int x2, int y1, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				tab[i][j] += 2;
			}
		}
	}

	void off2(int[][] tab, int x1, int x2, int y1, int y2) {

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if(tab[i][j] > 0) {
					tab[i][j]--;
				}
			}
		}
	}

	void on2(int[][] tab, int x1, int x2, int y1, int y2) {

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				tab[i][j]++;
			}
		}
	}

}
