package sample.web.ui;

import java.util.Arrays;
import java.util.Scanner;

public class Pingtu {
	static boolean[] vis = new boolean[362880];
	static int[] fact = new int[9];
	public static int MAXSTATE = 1000000;
	static state[] st = new state[MAXSTATE];
	static state goal = new state(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 });// 目标状态
	static int[] dist = new int[MAXSTATE];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int front = 1, rear = 2;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = new int[9];
		for (int i = 0; i < 9; i++)
			input[i] = scan.nextInt();
		dist[1] = 0;
		st[1] = new state(input);
		int result = dist[bfs()];
		result = result == 0 ? -1 : result;
		System.out.println(result);
	}

	static class state {// 状态类，这个类的每个对象存储一种状态
		int[] state = new int[9];

		public state(int[] state) {
			this.state = state;
		}
	}

	public static int bfs() {
		init_lookup_table();
		while (front < rear) {
			state s = st[front];
			if (Arrays.equals(s.state, goal.state))
				return front;
			int z;
			for (z = 0; z < 9; z++)
				if (0 == s.state[z])
					break;
			int x = z / 3;
			int y = z % 3; // 获取行列号(0-2)

			for (int d = 0; d < 4; d++) {
				int newx = x + dx[d];// 移动目标的横坐标
				int newy = y + dy[d];// 移动目标的纵坐标
				int newz = newx * 3 + newy;// 移动目标在下一状态的位置
				if (newx >= 0 && newx < 3 && newy >= 0 && newy < 3) {// 如果移动合法
					int[] temp = Arrays.copyOf(s.state, 9);
					st[rear] = new state(temp);
					st[rear].state[newz] = s.state[z];
					st[rear].state[z] = s.state[newz];
					dist[rear] = dist[front] + 1;
					if (try_to_insert(st[rear]))
						rear++;
				}
			}
			front++;
		}
		return 0;
	}

	public static boolean try_to_insert(state t) {
		int code = 0;
		for (int i = 0; i < 9; i++) {
			int cnt = 0;
			for (int j = i + 1; j < 9; j++) {
				if (t.state[j] < t.state[i])
					cnt++;
			}
			code += fact[8 - i] * cnt;
		}
		if (vis[code])
			return false;
		else {
			vis[code] = true;
			return true;
		}
	}

	public static void init_lookup_table() {
		fact[0] = 1;
		for (int i = 1; i < 9; i++)
			fact[i] = fact[i - 1] * i;
	}
}
