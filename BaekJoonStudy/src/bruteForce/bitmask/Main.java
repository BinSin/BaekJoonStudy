/*
 * https://www.acmicpc.net/problem/11723
 * BinSin
 */

package bruteForce.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			
			if(oper.equals("all")) {
				S = (int)Math.pow(2, 21) - 1;
				continue;
			} else if(oper.equals("empty")) {
				S = 0;
				continue;
			}
			
			int x = Integer.parseInt(st.nextToken());
			switch(oper) {
			case "add": S = S | (1 << x); break;
			case "remove": S = S & ~(1 << x); break;
			case "check": 
				if((S & (1 << x)) == 0) bw.write("0\n");
				else bw.write("1\n");
				break;
			case "toggle": S = S ^ (1 << x); break;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
