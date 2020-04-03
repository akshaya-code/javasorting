package onedarray;

public class HeapSort {
	/*private static int parent(int i) {
		if(i==0 ) {
			return -1;
		}
		return (i/2);
	}*/
	private static int left(int i) {
		if(i==0) {
			return 1;
		}
		return (2*i+1);
	}
	private static int right(int i) {
		if(i==0) {
			return 2;
		}
		return (2*i+2);
	}
	public static void heapSort(int A[]) {
		int lengthOfArray = A.length-1;
		int heapSize=A.length-1;
		buildMaxHeap(A,heapSize);
		for(int i=lengthOfArray;i>=1;i--) {
			int temp = A[0];
			A[0]=A[i];
			A[i]=temp;
			heapSize--;
			maxHeapify(A,0,heapSize);
		}
		
	}
	private static void maxHeapify(int[] a, int i,int heapSize) {
		int l,r,largest;
		l=left(i);
		r=right(i);
		if((l<=heapSize)&&(a[l]>a[i])) {
			largest=l;
		}
		else {
			largest=i;
		}
		if((r<=heapSize)&&(a[r]>a[largest])) {
			largest=r;
		}
		if(largest!=i) {
			int temp = a[i];
			a[i]=a[largest];
			a[largest]=temp;
			maxHeapify(a, largest, heapSize);
		}
	}
	private static void buildMaxHeap(int[] a,int heapSize) {
		for(int i=heapSize/2;i>=0;i--) {
			maxHeapify(a, i,heapSize);
		}
	}
	public static void main(String[] args) {
		int a[]= {7,8,3,5,10};
		heapSort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
	}
}
