package onedarray;

public class ArraySorting {
	public static void selectionSort(double[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			double currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	public static void insertionSort(double list[]) {
		for (int i = 0; i < list.length; i++) {
			double currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
	}

	public static void bubbleSort(double list[]) {
		int lengthOfList = list.length;
		for (int i = 0; i < lengthOfList; i++) {
			for (int j = lengthOfList - 1; j > i; j--) {
				if (list[j] < list[j - 1]) {
					double temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}
			}
		}
	}

	public static void quickSort(double list[]) {
		qSort(list, 0, (list.length - 1));
	}

	private static void qSort(double[] A, int p, int r) {
		int q;
		if (p < r) {
			q = partition(A, p, r);
			qSort(A, p, q - 1);
			qSort(A, q + 1, r);
		}

	}

	private static int partition(double[] A, int p, int r) {
		double x = 0;
		int i, j;
		x = A[r];
		i = p - 1;
		for (j = p; j < r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				double temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		double temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;
		return (i + 1);
	}

	public static void mergeSort(double list[]) {
		msort(list, 0, list.length - 1);
	}

	private static void msort(double[] list, int lb, int ub) {
		if (lb < ub) {
			int mid = (lb + ub) / 2;
			msort(list, lb, mid);
			msort(list, mid + 1, ub);
			merge(list, lb, mid, ub);
		}

	}

	private static void merge(double[] list, int lb, int mid, int ub) {
		double temp[] = new double[list.length];
		int i = lb;
		int j = mid + 1;
		int k = lb;
		while (i <= mid || j <= ub) {
			if (i > mid)
				temp[k++] = list[j++];
			else if (j > ub)
				temp[k++] = list[i++];
			else if (list[i] < list[j])
				temp[k++] = list[i++];
			else
				temp[k++] = list[j++];
		}
		for (j = lb; j <= ub; j++)
			list[j] = temp[j];
	}
}
