
public class InsertionSort {

	static int size = 1000;
	static int[] randomList;
	
	public static void main(String[] args) {
		long runTime;
		randomList = fillArray(size);
		runTime = System.currentTimeMillis();
		insertionSort(randomList);
		//selectionSort(randomList);
		runTime = System.currentTimeMillis()-runTime;
		printList(randomList, 10);
		System.out.println("Sort Run time: "+runTime);


	}
	public static int[] fillArray(int size) {
		int[] list = new int[size];
		int i;
		for (i=0; i<size; i++)
			list[i] = (int)(Math.random()*10000)+1;
		return list;
	}
	public static void insertionSort(int [] list){
		int i,j,k,t;
		int[] orderedList = new int[list.length];
		for (i=0; i<list.length; i++) {
			// Insert list[i] into ordered list
			t = list[i];
			for (j=i-1; j>=0; j--) {
				if (t<orderedList[j]) {
					orderedList[j+1] = orderedList[j];
				}
				else break;
			}
			orderedList[j+1] = t;
		}
		for (i=0; i<list.length; i++)
			list[i] = orderedList[i];
	}
	public static void printList(int[] list, int n) {
		int i;
		if (n<=0) n = list.length;
		if (n>list.length) n=list.length;
		for (i=0; i<n; i++)
			System.out.println(""+i+": "+list[i]);
	}
	public static void selectionSort(int[] list) {
		int i,j,s,t;
		for (i=0; i<list.length-1; i++) {
			s = i;
			for (j=i+1; j<list.length; j++)
				if (list[j]<list[s]) s = j;
			t = list[i];
			list[i] = list[s];
			list[s] = t;
		}
	}


}
