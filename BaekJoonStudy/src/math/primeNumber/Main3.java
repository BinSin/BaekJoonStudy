/*
 * https://www.acmicpc.net/problem/6588
 * BinSin
 */

package math.primeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main3 {
	public static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] checkPrimeNumber = new boolean[MAX+1];
		ArrayList<Integer> primeNumber = new ArrayList<Integer>();
        checkPrimeNumber[0] = true;
        for(int i=2; i<=MAX; i++) {
            if(checkPrimeNumber[i])
                continue;
            else
            	primeNumber.add(i);
            
            for(int j=i+i; j<=MAX; j+=i) {
                checkPrimeNumber[j] = true;
            }
        }
		
        int n;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			int s = 1, e = 0, sum = 0;
			for(e=1; e<primeNumber.size(); e++) {
				sum = primeNumber.get(s) + primeNumber.get(e);
				if(sum >= n) break;
			}
			if(e == primeNumber.size()) e--;
			
			while(s <= e) {
				if(sum == n) {
					bw.write(n + " = " + primeNumber.get(s) + " + " + primeNumber.get(e) + "\n");
					break;
				}
				else if(sum > n) {
					sum -= primeNumber.get(e--);
					sum += primeNumber.get(e);
				}
				else {
					sum -= primeNumber.get(s++);
					sum += primeNumber.get(s);
				}
			}
			if(n != sum)
				bw.write("Goldbach's conjecture is wrong.\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}