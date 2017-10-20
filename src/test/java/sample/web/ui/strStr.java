package sample.web.ui;

import java.util.Scanner;
public class strStr {
    public static int maxConsequenceSum(int[] input) {
        int res = 0, sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum > 0) {
                res = Math.max(sum, res);
            } else {
                sum = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(strStr.maxConsequenceSum(input));
    }
}