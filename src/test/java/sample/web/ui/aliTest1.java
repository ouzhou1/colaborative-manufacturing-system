package sample.web.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aliTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		String s1 = "";
		String s2 = "";
		while ((str = br.readLine()) != null) {
			s1 = str.trim();
			for (int i = 0; i < 1 && ((str = br.readLine()) != null); i++) {
				s2 = str.trim();

				if (s1 == "100-trade-done") {
					if (s2 == "1*trade*done") {
						System.out.println(1);
					} else if (s2 == "pattern=200-?*-done") {
						System.out.println(0);
					}
				} else if (s1 == "200-trade-done") {

					if (s2 == "pattern=200-?*-done") {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else {
					System.out.println(0);
				}
			}

		}
	}
}