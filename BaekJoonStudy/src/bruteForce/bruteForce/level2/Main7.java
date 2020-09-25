/*
 * BinSin
 * https://www.acmicpc.net/problem/2529
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main7 {
	
	static int k;
	static char[] sign;
	static boolean[] check;
	static ArrayList<String> ans;
	
	public static boolean possible(char x, char y, char op) {
		if(op == '<') {
			if(x > y) return false;
		}
		if(op == '>') {
			if(x < y) return false;
		}
		return true;
	}
	
	public static void go(int index, String num) {
		if(index == k+1) {
			ans.add(num);
			return;
		}
		for(int i=0; i<10; i++) {
			if(check[i]) continue;
			if(index == 0 || possible(num.charAt(index-1), (char)(i+'0'), sign[index-1])) {
				check[i] = true;
				go(index+1, num+Integer.toString(i));
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());
		check = new boolean[10];
		sign = new char[k+1];
		ans = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		go(0, "");
		Collections.sort(ans);
		bw.write(ans.get(ans.size() - 1) + "\n");
		bw.write(ans.get(0));
		bw.flush();
		bw.close();
		br.close();
	}
}
