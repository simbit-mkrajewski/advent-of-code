package pl.com.simbit;

public class Day1 implements Day {

	public String getAnswer1() {
		return null;
	}

	public String getAnswer2() {
		String input = FileReader.readProblem(1);

		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			count += input.charAt(i) == '(' ? 1 : -1;
			if (count < 0) {
				return (i + 1) + "";
			}
		}

		return null;
	}

}
