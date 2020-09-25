/*
 * https://www.acmicpc.net/problem/1978
 * BinSin
 */

package math.primeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean isPrimeNumber(int n) {
		if(n < 2) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			if(isPrimeNumber(Integer.parseInt(st.nextToken()))) answer++;
		}
		
		bw.write(answer + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
