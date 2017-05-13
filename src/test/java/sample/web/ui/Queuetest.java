package sample.web.ui;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queuetest {
	public static void main(String a[]) {
		List<String> list = new LinkedList<>();
		Queue<String> queueA = new LinkedList<>();
		list.add("1");
		list.remove("1");
		queueA.add("element 1");
		queueA.add("element 2");
		queueA.add("element 3");
		System.out.print(queueA.remove());
		System.out.print(queueA.element());
	}
}
