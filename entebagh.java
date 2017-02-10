import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entebagh {
	static int j = 0;
	static int w = 0;

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
					if (color[i] == 1)
						j++;
					else
						w++;
				}
				if (!check)
					break;
			}
		}
		return check;

	}

	static boolean bpm(int[][] g, int u, boolean seen[], int matchR[]) {

		for (int v = 0; v < j; v++) {

			if (g[u][v] > 0 && !seen[v]) {
				seen[v] = true;

				if (matchR[v] < 0 || bpm(g, matchR[v], seen, matchR)) {
					matchR[v] = u;
					return true;
				}
			}
		}
		return false;
	}

	static int maxBPM(int[][] g, int n) {

		int matchR[] = new int[j];

		for (int i = 0; i < j; ++i)
			matchR[i] = -1;

		int result = 0;
		for (int u = 0; u < w; u++) {
			boolean seen[] = new boolean[j];
			for (int i = 0; i < j; ++i)
				seen[i] = false;

			if (bpm(g, u, seen, matchR))
				result++;
		}
		return result;
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
			System.out.println(maxBPM(g, n));
		}

	}
}
