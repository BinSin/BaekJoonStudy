/*
 * BinSin
 * https://www.acmicpc.net/problem/3568
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main08 {

	public static String reverse(String type) {
		StringBuilder sb = new StringBuilder();
		int len = type.length();
		for(int i=len-1; i>=0; i--) {
			char c = type.charAt(i);
			 if(c == '[' || c == ']') {
				 sb.append(type.charAt(i-1)).append(c);
				 i--;
			 } else {
				 sb.append(c);
			 }
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String basic = st.nextToken();
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			int len = s.length();
			s = s.substring(0, --len);
			int index;
			for(index=0; index<len; index++) {
				char c = s.charAt(index);
				if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')
						|| ('0' <= c && c <= '9')) continue;
				else break;
			}
			String var = s.substring(0, index);
			String type = s.substring(index, len);
			type = reverse(type);
			bw.write(basic + type + " " + var + ";\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
