/*
 * https://www.acmicpc.net/problem/10430
 * BinSin
 */

package math.remainder;

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
		
		int A, B, C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bw.write((A+B)%C + "\n");
		bw.write(((A%C)+(B%C))%C + "\n");
		bw.write((A*B)%C + "\n");
		bw.write(((A%C)*(B%C))%C + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
