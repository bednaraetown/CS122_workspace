
public class Worker extends Thread{

	long bot,top;
	int id;
	
	public Worker(int i, long begin, long end) {
		bot = begin;
		top = end;
		id = i;
		if (bot%2==0) bot++;
	}
	public void run() {
		long m;
		for (m=bot; m<=top;m+=2) {
			if (isPrime(m))
				System.out.println(""+id+": "+m+" is prime");
		}
	}
	public long pow(long n) {
		long v=1;
		long i;
		for (i=1;i<=n;i++) 
			v*=2;
		return v;
	}
	
	public boolean isPrime(long x) {
		long i;
		for (i=3;i<=Math.sqrt(x); i+=2)
			if (x%i==0) return false;		
		return true;
		
	}
}
