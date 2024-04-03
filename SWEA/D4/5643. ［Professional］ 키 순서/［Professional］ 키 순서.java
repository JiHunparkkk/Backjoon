import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int n, m;
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());

			boolean[][] board = new boolean[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a, b; // a < b
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				board[a][b] = true;
			}

			int answer = findLoad(n, board);
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static int findLoad(int n, boolean[][] board) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (board[i][k] && board[k][j]) {
						board[i][j] = true;
					}
				}
			}
		}

		int[] cnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[i][j] || board[j][i]) {
					cnt[i]++;
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == n - 1) {
				result++;
			}
		}
		return result;
	}

}