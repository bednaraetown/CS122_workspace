
public class PrimeNextNumber {
	public static int[] primes = new int[1000000];
	public static int nextNumber = 5;
	public static int primeCount;
	public static int max = 1000000;
	
	public static void main(String[] args) throws InterruptedException {
		Worker[] thread = new Worker[4];
		
		long runTime, startTime;
		int i;
		
		primes[0] = 2;
		primes[1] = 3;
		primeCount = 2;
		runTime = System.currentTimeMillis();
		for (i=0;i<thread.length;i++) {
			thread[i] = new Worker(i);
			thread[i].start();
		}
		for (i=0;i<thread.length;i++) {
			thread[i].join();
		}
		
		runTime = System.currentTimeMillis() - runTime;
		System.out.println("Run Time: "+runTime);
		System.out.println("Primes count: "+primeCount);

	}
	
	

}
