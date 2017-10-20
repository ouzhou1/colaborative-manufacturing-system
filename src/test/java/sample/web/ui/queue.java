package sample.web.ui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue {
	public static void main(String[] args) {
//		double rate = 1.6f;
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        StringBuilder bcolors = new StringBuilder();
//        List<String> subColors = new ArrayList<>();
//        for (int i = 0; i < number; i++) {
//            bcolors.append(sc.nextInt());
//        }
//        String colors = bcolors.toString();
//        String subColor = null;
//        for (int i = 0; i < number; i++) {
//            int startIndex = 0;
//            if (subColor == null) {
//
//                subColor = colors.substring(i, i + 1);
//                startIndex = i;
//            } else {
//                if (subColor.contains(colors.substring(i, i + 1))) {
//                    subColors.add(subColor);
//                    subColor = colors.substring(i, i + 1);
//                    startIndex = i;
//                } else {
//                    subColor = colors.substring(startIndex, i + 1);
//                }
//
//            }
//        }
//        subColors.add(subColor);
//
//        int result = 1;
//        for (int i = 0; i < subColors.size(); i++) {
//            result *= (int) Math.pow(2, subColors.get(i).length() - 1);
//        }
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] input = new int[len];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		int[] output = new int[len];
		output[len-1] = -1;
		for (int i = len-2; i >= 0; i--) {
			if (input[i] < input[i+1]) {
				output[i] = input[i+1];
			} else {
				output[i] = output[i+1];
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.println(output[i]);
		}
    }
}
