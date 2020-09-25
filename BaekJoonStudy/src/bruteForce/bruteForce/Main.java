/*
 * https://www.acmicpc.net/problem/2309
 * BinSin
 */

package bruteForce.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> talls = new ArrayList<Integer>();
		
		for(int i=0; i<9; i++) {
			talls.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(talls);
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				ArrayList<Integer> t = (ArrayList)talls.clone();
				t.remove(i);
				t.remove(j-1);
				int sum = 0;
				for(int k=0; k<7; k++) {
					sum += t.get(k);
				}
				if(sum == 100) {
					for(int l=0; l<7; l++) {
						bw.write(t.get(l) + "\n");
					}
					br.close();
					bw.flush();
					bw.close();
					return;
				} else {
					continue;
				}
			}
		}
	}
}
