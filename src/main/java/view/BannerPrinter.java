package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BannerPrinter {

	public static void print() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/main/resources/banner.txt"));
		String line = in.readLine();
		while (line != null) {
			System.out.println(line);
			line = in.readLine();
		}
		in.close();
	}

}
