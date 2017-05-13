package sample.web.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JVMTest {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != index) {
                res.add(index);
                index++;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		ClassLoader loader = JVMTest.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
		
		int[] res = {4,3,2,7,8,2,3,1};
		System.out.println(String.format("123/%s", "acd"));
		System.out.println(res.getClass());
		Arrays.sort(res);
		System.out.println(JVMTest.findDisappearedNumbers(res));
		//输入一组数据并输出 
        Scanner sc = new Scanner(System.in); 
        String str=sc.nextLine(); 
        System.out.printf("%s\n",str); 

        //输入多组数据并输出 
        Scanner scr = new Scanner(System.in); 
        String string; 
        while(sc.hasNextLine()){ 
             str = sc.nextLine(); 
            System.out.printf("%s\n",str); 
         } 
	}
}
