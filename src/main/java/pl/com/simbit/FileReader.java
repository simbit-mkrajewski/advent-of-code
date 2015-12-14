package pl.com.simbit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class FileReader {

	public static String readProblem(int day) {
		try {
			InputStream stream = FileReader.class.getClassLoader().getResourceAsStream(day + ".txt");
			return IOUtils.toString(stream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<String> readProblemLines(int day) {
		try {
			InputStream stream = FileReader.class.getClassLoader().getResourceAsStream(day + ".txt");
			return IOUtils.readLines(stream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
