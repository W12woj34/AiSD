package sortsAlgorithms;

public class HeapSort {

	public void sort(Integer tab[]) {

		for (int i = tab.length / 2 - 1; i >= 0; i--) {
			heapify(tab, tab.length, i);
		}

		for (int i = tab.length - 1; i >= 0; i--) {

			int temp = tab[0];
			tab[0] = tab[i];
			tab[i] = temp;

			heapify(tab, i, 0);
		}
	}

	void heapify(Integer tab[], int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && tab[left] > tab[largest]) {
			largest = left;
		}

		if (right < n && tab[right] > tab[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = tab[i];
			tab[i] = tab[largest];
			tab[largest] = temp;

			heapify(tab, n, largest);
		}
	}

}