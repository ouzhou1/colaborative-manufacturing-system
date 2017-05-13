package sample.web.ui;

import java.util.Arrays;
import java.util.Scanner;
public class FiveFortune {
	public static int cardsMerge(String[] cards) {
		if(cards == null || cards.length == 0) return -1;
		int[] res = new int[5];
		for(int i = 0; i < cards.length; i++) {
			int card_len = cards[i].length();
			if(card_len != 5) return -1;
			else 
				for(int j = 0; j < 5; j++) 
					res[j] = cards[i].charAt(j) == '1' ? res[j]+1:res[j];
		}
		int ans = res[0];
		for(int i = 1; i < 5; i++)
			if(res[i] < ans) ans = res[i];
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = new String[10];
		input[0] = sc.nextLine();
		int count = 0;
		for(int i = 1; i<10 && !input[i-1].equals("EOF"); i++) {
			input[i] = sc.nextLine();
			count++;
		}
		String[] cards = Arrays.copyOf(input, count);
		System.out.println(FiveFortune.cardsMerge(cards));
	}
}
