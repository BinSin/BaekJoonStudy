/*
 * https://www.acmicpc.net/problem/9613
 * BinSin
 */

package math.gcd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {
	
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			long answer = 0; // 1000000 * 100 * 99 / 2 = 10억 넘음
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] num = new int[N];
			int j = 0;
			while(st.hasMoreElements()) {
				num[j++] = Integer.parseInt(st.nextToken());
			}

			for(int a=0; a<N-1; a++) {
				for(int b=a+1; b<N; b++) {
					int gcd = gcd(num[a], num[b]);
					answer += gcd;
				}
			}
			
			bw.write(answer + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
