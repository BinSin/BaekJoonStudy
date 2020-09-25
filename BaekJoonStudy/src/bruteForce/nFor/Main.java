/*
 * https://www.acmicpc.net/problem/9095
 * BinSin
 */

package bruteForce.nFor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { // n중 for문 쓰지 않고 DP 씀
	
	static final int MAX = (int)Math.pow(3, 10);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[11][MAX+1];
		arr[1][1] = 1; arr[1][2] = 2; arr[1][3] = 3;
		for(int i=2; i<11; i++) {
			int k = 1;
			for(int j=1; j<=(int)Math.pow(3,i-1); j++) {
				for(int n=1; n<=3; n++) {
					arr[i][k++] = arr[i-1][j] + n;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			int count = 0;
			int n = Integer.parseInt(br.readLine());
			for(int j=1; j<=n; j++) {
				for(int k=1; k<arr[j].length && arr[j][k] != 0; k++) {
					if(arr[j][k] == n) count++;
				}
			}
			bw.write(count + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
