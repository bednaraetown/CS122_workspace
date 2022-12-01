
public class RadixSort {
	LinkedList master = new LinkedList();
	LinkedList[] bin = new LinkedList[100];
	
	public RadixSort() {
		int i;
		for (i=0; i<bin.length; i++) 
			bin[i] = new LinkedList();
	}
	
	public int[] sort(int[] list) throws Exception {
		int i,j,d;
		int max=-1;
		int divisor = 1;
		LinkedList.Node p;
		
		for (int v:list) {
			master.insertRear(v);
			if (v>max) max = v;
		}
		
		for (divisor=1; divisor<=max; divisor*=100) {
			while (!master.empty()) {
				p = master.removeNodeFront();
				d = (p.data/divisor) % 100;
				bin[d].insertRear(p);
			}
			for (i=0; i<bin.length; i++)
				master.append(bin[i]);
		}
/*		
		for (int d:master)
			list[i] = d;
*/
		return list;

	}

}
