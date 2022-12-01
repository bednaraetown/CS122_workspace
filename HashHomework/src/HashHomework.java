
public class HashHomework {

	public static void main(String[] args) {
		HashTable tbl = new HashTable(1000);
		int i,n,j;
		
		while (tbl.utilization()<80.0) {
			n = (int)(Math.random()*1000000);
		//	if (!tbl.containsKey(n))
				tbl.put(n);
		}
		
		System.out.println("Utilization: "+tbl.utilization());
		System.out.println("Table load:  "+tbl.size);
		System.out.println("Collisions:  "+tbl.collisions);
		System.out.println("Collision rate: "+tbl.collisionRate());
	}

}
