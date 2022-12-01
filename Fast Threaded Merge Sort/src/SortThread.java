
public class SortThread extends Thread{
	int[] data;
	int level;

	public SortThread(int[] data, int level) {
		this.data = data;
		this.level = level;
	}

	public void run() {
		if (data.length<=1) return;
		if (level>MergeSort.maxlevel) MergeSort.maxlevel = level;
		int[] lista = new int[data.length/2];
		int[] listb = new int[data.length - lista.length];
		SortThread threada, threadb;
		int a,b,c=0;
		for (a=0; a<lista.length; a++)
			lista[a] = data[c++];
		for (b=0; b<listb.length; b++)
			listb[b] = data[c++];
		threada = new SortThread(lista, level+1);
		threadb = new SortThread(listb, level+1);
		threada.start();
		threadb.start();
		try {
			threada.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);   
		}
		try {
			threadb.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
		merge(lista,listb, data);
	}

	private void merge(int[] lista, int[] listb, int[] data) {
		int a=0,b=0,c=0;
		while (a<lista.length && b<listb.length) {
			if (lista[a] <= listb[b])
				data[c++] = lista[a++];
			else
				data[c++] = listb[b++];
		}
		while (a<lista.length)
			data[c++] = lista[a++];
		while (b<listb.length)
			data[c++] = listb[b++];
	}
}

