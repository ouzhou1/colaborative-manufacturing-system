package sample.web.ui;

import java.util.HashSet;
import java.util.Set;

public class findListCycle {
	public static void main(String[] a) {
		Set<String> set = new HashSet<String>();
		String s = "     a   b  ";
		String[] sarr = s.split(" ");
		for(int i = 0; i < sarr.length; i++) {
			System.out.println(sarr[i]);
		}
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s.trim().length());
		char[] a1 = s.toCharArray();
		String s1 = String.valueOf(a1);
	}

}
