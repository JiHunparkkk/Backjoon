import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][k + 1];
		// dp[n][k] = dp[n][k - 1] + dp[n - 1][k]

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], 1);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j == 1) {
					dp[i][j] = 1;
					continue;
				}

				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
			}
		}

		System.out.println(dp[n][k] % 1_000_000_000);
	}
}