package sample.web.ui;

import java.util.Scanner;

public class Filter {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int res = 0;
        for (int i = 2; i <= input/2; i++) {
            if (isSushu(i)) {
                if (isSushu(input-i)) {
                    res++;
                }
            }
        }
        System.out.print(res);
    }
    static boolean isSushu(int input) {
        int j = input / 2;
        for (int i = 2; i <= j; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}