/*
 * https://www.acmicpc.net/problem/6603
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] number, ArrayList<Integer> lotto, int i) throws IOException {
		if(lotto.size() == 6) {
			for(int n=0; n<6; n++) {
				bw.write(lotto.get(n) + " ");
			}
			bw.write("\n");
			return;
		}
		
		if(i >= number.length) return;
		
		ArrayList<Integer> addLotto = (ArrayList<Integer>)lotto.clone();
		addLotto.add(number[i]);
		go(number, addLotto, i+1);
		go(number, lotto, i+1);
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			int[] number = new int[n];
			for(int i=0; i<n; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			go(number, new ArrayList<Integer>(), 0);
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
