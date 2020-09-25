/*
 * BinSin
 * https://www.acmicpc.net/problem/1248
 */

package bruteForce.bruteForce.level2;
/*
 * BinSin
 * https://www.acmicpc.net/problem/1248
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main8 {
	
	static int N;
	static int[][] sign;
	static int[] ans;
	
	public static boolean check(int index) {
		int sum = 0;
		for(int i=index; i>=0; i--) {
			sum += ans[i];
			if(sign[i][index] == -1) {
				if(sum >= 0) return false;
			}
			if(sign[i][index] == 0) {
				if(sum != 0) return false;
			}
			if(sign[i][index] == 1) {
				if(sum <= 0) return false;
			}
		}
		return true;
	}
	
	public static boolean go(int index) {
		if(index == N) {
			return true;
		}
		if(sign[index][index] == 0) {
			ans[index] = 0;
			return check(index) && go(index+1);
		}
		
		for(int i=1; i<=10; i++) {
			ans[index] = sign[index][index] * i;
			if(check(index) && go(index+1)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String signs = br.readLine();
		sign = new int[N][N];
		for(int i=0, k=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				char s = signs.charAt(k++);
				if(s == '-') sign[i][j] = -1;
				if(s == '0') sign[i][j] = 0;
				if(s == '+') sign[i][j] = 1;
			}
		}
		ans = new int[N];
		
		go(0);
		
		for(int i=0; i<N; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
