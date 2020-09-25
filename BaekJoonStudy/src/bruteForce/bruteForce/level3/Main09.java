/*
 * BinSin
 * https://www.acmicpc.net/problem/4902
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main09 {
	
	static int n;
	static int[][] t;
	static int[][] s;
	static int answer;
	
	static void max(int row, int left, int right, int sum) {
		if(row < 1 || row > n) return;
		if(left < 1 || right > 2*row-1) return;
		sum += s[row][right] - s[row][left-1];
		if(answer < sum) answer = sum;
		if(left % 2 == 0) {
			max(row-1, left-2, right, sum);
		} else {
			max(row+1, left, right+2, sum);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			answer = -400000;
			t = new int[n+1][n*2+1];
			s = new int[n+1][n*2+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=i*2-1; j++) {
					s[i][j] = s[i][j-1] + (t[i][j] = Integer.parseInt(st.nextToken()));
				}
			}
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=i*2-1; j++) {
					max(i, j, j, 0);
				}
			}
			bw.write(count++ + ". " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
