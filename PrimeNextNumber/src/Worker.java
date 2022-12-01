
public class Worker extends Thread{
	private int id;
	Object lock = new Object();

	public Worker(int i) {
		id=i;
	}

	public void run() {
		int n;
		while(PrimeNextNumber.nextNumber<=PrimeNextNumber.max) {
			synchronized(lock) {
				n = PrimeNextNumber.nextNumber;
				PrimeNextNumber.nextNumber+=2;
			}
			if(isPrime(n)) {
				synchronized(lock) {
					PrimeNextNumber.primes[PrimeNextNumber.primeCount++] = n;
				}
				//System.out.println(""+id+": "+n);
			}
		}
	}

	public boolean isPrime(int x) {
		int i;
		if (x%2==0) return false;
		for (i=3;i<=Math.sqrt(x); i+=2)
			if (x%i==0) return false;		
		return true;

	}

}
