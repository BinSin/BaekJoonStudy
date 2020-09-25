/*
 * https://www.acmicpc.net/problem/1759
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static boolean checkPassword(String password) {
		char[] pas = password.toCharArray();
		int consonant = 0; // 자음
		int vowel = 0; // 모음
		for(int i=0; i<password.length(); i++) {
			char p = pas[i];
			if(p == 'a' || p == 'e' || p == 'i' || p == 'o' || p == 'u')
				vowel++;
			else
				consonant++;
		}
		
		if(consonant >= 2 && vowel >= 1) return true;
		else return false;
	}
	
	public static void go(int L, char[] alpha, String password, int n) throws IOException {
		if(password.length() == L) { // 정답을 찾은 경우
			if(checkPassword(password)) {
				bw.write(password + "\n");
				return;
			}
			else return;
		}
		
		if(n >= alpha.length) return; // 불가능한 경우
		// 다음 경우 호출
		go(L, alpha, password + alpha[n], n+1); // 사용 o
		go(L, alpha, password, n+1); // 사용 x
		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		char[] alpha = new char[C];
		String p = "";
		while(st.hasMoreTokens()) {
			p += st.nextToken();
		}
		alpha = p.toCharArray();
		Arrays.sort(alpha);
		
		go(L, alpha, "", 0);
		
		br.close();
		bw.flush();
		bw.close();
	}
}
