/*
 * https://www.acmicpc.net/problem/1929
 * BinSin
 */

package math.primeNumber;

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
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] checkPrimeNumber = new boolean[N+1];
		checkPrimeNumber[0] = true;
		for(int i=2; i<N+1; i++) {
			if(checkPrimeNumber[i])
				continue;
			if(!checkPrimeNumber[i] && M<=i)
				bw.write(i + "\n");
			for(int j=2; i*j<N+1; j++) { // j=i 로 두게 되면 백만*백만 으로 int 범위 넘어서게 된다.
				checkPrimeNumber[i*j] = true;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
