import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entebagh {

	static boolean bfs(int[][] g, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] color = new int[n];
		boolean[] mark = new boolean[n];
		color[0] = 1;
		q.add(0);
		boolean check = true;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 0; i < n; i++) {
				if (g[node][i] == 1) {
					if (!mark[i]) {
						q.add(i);
						mark[i] = true;
					}
					if (color[i] == color[node]) {
						check = false;
						break;
					}
					color[i] = -color[node];
				}
				if (!check)
					break;
			}
		}
		return check;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), e = in.nextInt();
		int[][] g = new int[n][n];

		for (int k = 0; k < e; k++) {
			int i = in.nextInt(), j = in.nextInt();
			g[i][j] = 1;
			g[j][i] = 1;
		}
		if (!bfs(g, n)) {
			System.out.println("dobakhsi nist");
		} else {
			System.out.println("odafez");
		}

	}

}
