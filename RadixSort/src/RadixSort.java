
public class RadixSort {
	static int[] list;

	public static void main(String[] args) {
		
		list = randomList(1000000);
		LinkedList data = new LinkedList();
		for (int i:list)
			data.insertRear(i);
		radixSort(data);

	}

	public static void radixSort(LinkedList master) {
		long startTime = System.currentTimeMillis();
		LinkedList[] bins = new LinkedList[10];
		int divisor,d,i;
		LinkedList.Node p;
		for(i=0;i<bins.length;i++)
			bins[i]=new LinkedList();

		for(divisor=1;divisor<1000000;divisor*=10) {
			while(!master.empty()) {
				p = master.removeFirst();
				d = (p.value/divisor) %10;
				bins[d].insertLast(p);
			}
			for(i=0;i<bins.length;i++) {
				master.append(bins[i]);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		System.out.println("Sorted Data: ");
		for(i=0;i<20;i++) {
			LinkedList.Node t = master.removeFirst();
			System.out.println(t.value);
		}
	}

	public static int[] randomList(int size) {
		int[] list = new int[size];
		int i;
		for (i=0; i<list.length;i++)
			list[i] = (int)(Math.random()*100000);
		return list;
	}
}
