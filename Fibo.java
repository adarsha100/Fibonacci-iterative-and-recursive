import java.util.Arrays;
import java.math.BigInteger;
public class Fibo {
	public static void main(String[] args) {

		for(int n = 0; n < 1000; n++) {
			System.out.println(fibo(n, new BigInteger[n+1]));
			System.out.println(fiboIterative(n));
		}
	}

	private static BigInteger fibo(int n, BigInteger[] alreadyComputed) {
		if(n == 0) 
			return new BigInteger("0");
		
		if(n == 1 || n == 2) 
			return new BigInteger("1");

		if(alreadyComputed[n-1] != null)
			return alreadyComputed[n];

		BigInteger num = fibo(n-1 , alreadyComputed).add(fibo(n-2, alreadyComputed));
		alreadyComputed[n] = num;
		return num;
	}

	private static BigInteger fiboIterative(int n) {

		BigInteger[] fibs = {new BigInteger("1"), new BigInteger("1")};

		for(int i = 3; i <= n; i++) {
			BigInteger temp = fibs[1];
			fibs[1] = fibs[1].add(fibs[0]);
			fibs[0] = temp;
		}

		return fibs[1];
	}
}
