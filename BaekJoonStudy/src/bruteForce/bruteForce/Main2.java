/*
 * https://www.acmicpc.net/problem/1476
 * BinSin
 */

package bruteForce.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());	// 1 <= E <= 15
		int S = Integer.parseInt(st.nextToken());	// 1 <= S <= 28
		int M = Integer.parseInt(st.nextToken());	// 1 <= M <= 19
		
		int count = 0;
		for(int e=1,s=1,m=1; e<=15 && s<=28 && m<=19; e++,s++,m++) {
			count++;
			if(E == e && S == s && M == m) break;
			if(e == 15) e = 0;
			if(s == 28) s = 0;
			if(m == 19) m = 0;
		}
		
		bw.write(count +"");
		br.close();
		bw.flush();
		bw.close();
	}
}
