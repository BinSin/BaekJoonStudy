package math.primeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main4 {
   
	static int[] primes = new int[100000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=2, j=1; i<=1000000; i++) {
			if(isPrime(i))
				primes[j++] = i;
		}
		
		while(n != 0) {
			
			int e;
			int sum = 0;
			for(e=1; e<primes.length; e++) {
				sum = primes[1] + primes[e];
				if(sum >= n)
					break;
			}
			
			int i = 1;
			if(n > primes[i]) {
				while(i <= e) {
					if(sum == n) {
						bw.write(n + " = " + primes[i] + " + " + primes[e] + "\n");
						break;
					}
					else if(sum > n) {
						sum -= primes[e--];
						sum += primes[e];
					}
					else {
						sum -= primes[i++];
						sum += primes[i];
					}
				}
				if(sum != n)
					bw.write("Goldbach's conjecture is wrong.\n");
			}
			else {
				bw.write("Goldbach's conjecture is wrong.\n");
			}
			
			n = Integer.parseInt(br.readLine());
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static boolean isPrime(int n) {
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}