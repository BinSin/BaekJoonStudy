/*
 * BinSin
 * https://www.acmicpc.net/problem/9663
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main9 {
	
	static int n;
	static boolean[][] ans = new boolean[15][15];
	static boolean[] check_col = new boolean[15];
	static boolean[] check_dig = new boolean[31];
	static boolean[] check_dig2 = new boolean[31];
	
	static boolean check(int row, int col) {
		if(check_col[col]) {
			return false;
		}
		if(check_dig[row+col]) { // /
			return false;
		}
		if(check_dig2[row-col+n]) { // \
			return false;
		}
		return true;
	}
	
	static int calc(int row) {
		if(row == n) {
			return 1;
		}
		
		int count = 0;
		for(int col=0; col<n; col++) {
			if(check(row, col)) {
				check_col[col] = true;
				check_dig[row+col] = true;
				check_dig2[row-col+n] = true;
				ans[row][col] = true;
				count += calc(row+1);
				
				check_col[col] = false;
				check_dig[row+col] = false;
				check_dig2[row-col+n] = false;
				ans[row][col] = false;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		bw.write(calc(0) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
