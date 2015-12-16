package pl.com.simbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 implements Day {

	enum Op {
		AND, OR, LSHIFT, RSHIFT, NOT;
	}

	public String getAnswer1() {
		List<String> readProblemLines = FileReader.readProblemLines(7);

		Map<String, Integer> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();

		for (String s : readProblemLines) {
			String[] split = s.split(" -> ");
			map2.put(split[1], split[0]);
		}

		Integer loadValue = loadValue(map2, "a");
		return loadValue + "";
	}

	private Integer loadValue(Map<String, String> map2, String string) {
		String s = map2.get(string);
		if (StringToInt.get(s) != null) {
			Integer integer = StringToInt.get(map2.get(string));
			map2.put(string, integer + "");
			return integer;
		}
		if (StringToInt.get(string) != null) {
			return StringToInt.get(string);
		}
		String operation = map2.get(string);
		Op op = getOp(operation);
		if (op == null) {
			Integer loadValue = loadValue(map2, operation);
			map2.put(string, loadValue + "");
			return loadValue;
		}
		String[] split2 = operation.split(op.name());
		if (op == Op.NOT) {
			Integer value = value(op, loadValue(map2, split2[1].trim()));
			map2.put(string, value + "");
			return value;
		}
		Integer value = value(op, loadValue(map2, split2[0].trim()), loadValue(map2, split2[1].trim()));
		map2.put(string, value + "");
		return value;
	}

	private Op getOp(String string) {
		if (string.contains("RSHIFT")) {
			return Op.RSHIFT;
		}
		if (string.contains("LSHIFT")) {
			return Op.LSHIFT;
		}
		if (string.contains("NOT")) {
			return Op.NOT;
		}
		if (string.contains("AND")) {
			return Op.AND;
		}
		if (string.contains("OR")) {
			return Op.OR;
		}
		return null;
	}

	private Integer value(Op op, Integer... values) {
		switch (op) {
		case AND:
			return values[0] & values[1];
		case LSHIFT:
			return values[0] << values[1];
		case NOT:
			return 65535 - values[0];
		case OR:
			return values[0] | values[1];
		case RSHIFT:
			return values[0] >> values[1];
		}
		throw new RuntimeException("Unknown operator " + op);
	}

	public String getAnswer2() {
		List<String> readProblemLines = FileReader.readProblemLines(7);

		Map<String, Integer> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();

		for (String s : readProblemLines) {
			String[] split = s.split(" -> ");
			map2.put(split[1], split[0]);
		}
		map2.put("b", "956");

		Integer loadValue = loadValue(map2, "a");
		return loadValue + "";
	}

}
