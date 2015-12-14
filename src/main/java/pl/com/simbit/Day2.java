package pl.com.simbit;

import java.util.List;

public class Day2 implements Day {

	public String getAnswer1() {
		List<String> readProblemLines = FileReader.readProblemLines(2);

		int feets = 0;

		for (String s : readProblemLines) {
			int w, h, l, wh, wl, hl;
			String[] dims = s.split("x");
			w = Integer.parseInt(dims[0]);
			h = Integer.parseInt(dims[1]);
			l = Integer.parseInt(dims[2]);
			wh = w * h;
			wl = w * l;
			hl = h * l;
			feets += 2 * wh;
			feets += 2 * wl;
			feets += 2 * hl;
			feets += Math.min(Math.min(wl, wh), hl);

		}
		return feets + "";
	}

	public String getAnswer2() {
		List<String> readProblemLines = FileReader.readProblemLines(2);

		int feets = 0;

		for (String s : readProblemLines) {
			int w, h, l, wh, wl, hl;
			String[] dims = s.split("x");
			w = Integer.parseInt(dims[0]);
			h = Integer.parseInt(dims[1]);
			l = Integer.parseInt(dims[2]);
			wh = 2 * w + 2 * h;
			wl = 2 * w + 2 * l;
			hl = 2 * h + 2 * l;
			feets += Math.min(Math.min(wl, wh), hl);
			feets += (w * h * l);

		}
		return feets + " - " + 3752260;
	}

}
