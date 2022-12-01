
public class MersennePrimes {

	public static void main(String[] args) throws InterruptedException {
		long n = 22812364129190929L;
		int range = 50;
		long startTime,endTime,runTime;
		Worker[] bee = new Worker[8];
		int i;
		startTime = System.currentTimeMillis();
		for (i=0; i<bee.length; i++) {
			bee[i] = new Worker(i,n, n+range);
			n+=range;
			bee[i].start();
			
		}
		for (i=0; i<bee.length; i++) {
			bee[i].join();
		}
		endTime = System.currentTimeMillis();
		runTime = endTime - startTime;
		System.out.println("Run Time: "+runTime);
	}


}
