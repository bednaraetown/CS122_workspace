
public class RadixSort {
	LinkedList master = new LinkedList();
	LinkedList[] bin = new LinkedList[10];

	public RadixSort() {
		int i;
		for (i=0;i<bin.length;i++)
			bin[i] = new LinkedList();
	}

	public int[] sort(int[] list) throws Exception {
		int i,j,d;
		int max = -1;
		int divisor = 1;
		for(i=0;i<list.length;i++) {
			d = list[i];
			master.insertRear(d);
			if(d>max) max = d;
		}
		for(divisor = 1; divisor<=max;divisor*=10) {
			while(!master.empty()) {
				i = master.removeFront();
				d = (i/divisor) % 10;
				bin[d].insertRear(i);
			}
			for(i=0;i<bin.length;i++)
				master.append(bin[i]);
		}
		
		
		for(i=0;!master.empty();i++)
			list[i] = master.removeFront();
		return list;
	}
}


