package pl.com.simbit;

import java.util.List;

public class Day3 implements Day {

	public String getAnswer1() {

		String moves = FileReader.readProblem(3);
		int x = 100, y = 100;
		int[][] ar = new int[2000][2000];
		ar[x][y]++;
		for (int i = 0; i < moves.length(); i++) {
			char move = moves.charAt(i);
			switch (move) {
			case '>':
				y++;
				break;
			case '<':
				y--;
				break;
			case '^':
				x--;
				break;
			case 'v':
				x++;
				break;
			default:
				System.out.println("CHAR " + move);
			}
			ar[x][y]++;

		}
		int count = 0;
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				if (ar[i][j] > 0) {
					count++;
				}
			}
		}
		return count + "";
	}

	public String getAnswer2() {
		String moves = FileReader.readProblem(3);
		int x = 100, y = 100;
		int xR = 100, yR = 100;
		int[][] ar = new int[2000][2000];
		ar[x][y]++;
		for (int i = 0; i < moves.length(); i++) {
			char move = moves.charAt(i);
			switch (move) {
			case '>':
				if (i % 2 == 0)
					y++;
				else
					yR++;
				break;
			case '<':
				if (i % 2 == 0)
					y--;
				else
					yR--;
				break;
			case '^':
				if (i % 2 == 0)
					x--;
				else
					xR--;
				break;
			case 'v':
				if (i % 2 == 0)
					x++;
				else
					xR++;
				break;
			default:
				System.out.println("CHAR " + move);
			}
			if (i % 2 == 0)
				ar[x][y]++;
			else
				ar[xR][yR]++;

		}
		int count = 0;
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				if (ar[i][j] > 0) {
					count++;
				}
			}
		}
		return count + "";
	}

}
