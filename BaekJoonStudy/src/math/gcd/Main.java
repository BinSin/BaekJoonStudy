/*
 * https://www.acmicpc.net/problem/2609
 * BinSin
 */

package math.gcd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a, b);
		int lcm = a * b / gcd;
		
		bw.write(gcd + "\n");
		bw.write(lcm + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
