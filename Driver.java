package onedarray;

public class Driver {

	public static void main(String[] args) {
		double list[]= {5,8,2,1,4};
		ArraySorting.quickSort(list);
		for(double d:list)
			System.out.print(d+"\t");
	}

}
