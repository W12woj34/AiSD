package sortsAlgorithms;

class QuickSort {

	void sort(Integer tab[], int low, int high) {
		if (low < high) {

			int index = partition(tab, low, high);

		
			sort(tab, low, index - 1);
			sort(tab, index + 1, high);
		}
	}

	int partition(Integer tab[], int low, int high) {
		// Random random = new Random();
		int pivot = tab[high];
		// pivot = tab[random.nextInt(high)];

		int i = (low - 1);
		for (int j = low; j < high; j++) {

			if (tab[j] <= pivot) {
				i++;

				int temp = tab[i];
				tab[i] = tab[j];
				tab[j] = temp;
			}
		}

		int temp = tab[i + 1];
		tab[i + 1] = pivot;
		tab[high] = temp;

		return i + 1;
	}

}