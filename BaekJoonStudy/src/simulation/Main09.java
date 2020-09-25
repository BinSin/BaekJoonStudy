/*
 * BinSin
 * https://www.acmicpc.net/problem/2290
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main09 {

	public static boolean[][] check = 
		{
				{true, true, true, false, true, true, true,},
				{false, false, true, false, false, true, false},
				{true, false, true, true, true, false, true},
				{true, false, true, true, false, true, true},
				{false, true, true, true, false, true, false},
				{true, true, false, true, false, true, true},
				{true, true, false, true, true, true, true},
				{true, false, true, false, false, true, false},
				{true, true, true, true, true, true, true},
				{true, true, true, true, false, true, true}
		};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		int len = n.length();
		int index = 0;
		for(int i=0; i<5; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<len; j++) {
				int num = n.charAt(j) - '0';
				if(i == 0 || i == 2 || i == 4) {
					sb.append(" ");
					for(int k=0; k<s; k++) {
						if(check[num][index]) sb.append("-");
						else sb.append(" ");
					}
					sb.append("  ");
				} else {
					if(check[num][index]) sb.append("|");
					else sb.append(" ");
					for(int k=0; k<s; k++) {
						sb.append(" ");
					}
					if(check[num][index+1]) sb.append("|");
					else sb.append(" ");
					sb.append(" ");
				}
			}
			
			
			if(i == 0 || i == 2 || i == 4) {
				index++;
				bw.write(sb.toString() + "\n");
			} else {
				index+=2;
				for(int k=0; k<s; k++) {
					bw.write(sb.toString() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
