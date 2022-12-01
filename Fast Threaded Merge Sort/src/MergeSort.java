
public class MergeSort {

	static final int size=1000;
	static int[] randomList;
	static int maxlevel = 8;
	
	public static void main(String[] args) throws InterruptedException {
		int[] list;
		randomList = fillArray(size);
		SortThread worker;
		randomList = fillArray(size);
		list = copy(randomList);
		long startTime = System.currentTimeMillis();
		worker = new SortThread(list, 0);
		worker.start();
		worker.join();
		long runTime = System.currentTimeMillis()-startTime;
		System.out.println("Run Time: "+runTime);
		
	}
	public static int[] fillArray(int size) {
		int[] list = new int[size];
		int i;
		for (i=0; i<size; i++)
			list[i] = (int)(Math.random()*1000000);
		return list;
	}
	public static int[] copy(int[] list) {
		int i;
		int[] list2 = new int[list.length];
		for (i=0; i<list.length; i++)
			list2[i] = list[i];
		return list2;
	}
}
/*
Data     Thread             normal
1k=       315               1
10k=     8230               3
100k=   877304				25
1Mil=    too long          258
*/
