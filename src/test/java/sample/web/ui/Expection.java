package sample.web.ui;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Expection {
	public static String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].length()<2) list.add(words[i]);
            for(int j = 1; j < words[i].length(); j++) {
                String firstAlphabet = String.valueOf(words[i].charAt(0)).toLowerCase();
                String position = first.contains(firstAlphabet)?first:second.contains(firstAlphabet)?second:third;
                if(j == words[i].length() - 1) list.add(words[i]);
                if(!position.contains(String.valueOf(words[i].charAt(j)))) break;
            }
        }
        String[] sArr = new String[list.size()];
        sArr = list.toArray(sArr);
        return sArr;
    }
	public static void main(String[] s) {
		DecimalFormat df = new DecimalFormat("#.000");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int possibility = 0;
		int numbers = 0;
		double res = 0;
		for(int i = 0; i < num; i++) {
			possibility = sc.nextInt();
			numbers = sc.nextInt();
			res = res + possibility*numbers;
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(sb == null);
		System.out.print(df.format(res/100));
		String input[] = {"aa","Alaska","Hello","Dad","Peace"};
		for(int i = 0; i < Expection.findWords(input).length; i++)
			System.out.println(Expection.findWords(input)[i]);
	}
}