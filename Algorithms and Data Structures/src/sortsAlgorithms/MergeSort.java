package sortsAlgorithms;

class MergeSort {

	void sort(Integer tab[], int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;

			sort(tab, left, mid);
			sort(tab, mid + 1, right);

			merge(tab, left, mid, right);
		}
	}

	void merge(Integer tab[], int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int leftTab[] = new int[n1];
		int rightTab[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftTab[i] = tab[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightTab[j] = tab[mid + 1 + j];
		}

		int i = 0;
		int j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (leftTab[i] <= rightTab[j]) {
				tab[k] = leftTab[i];
				i++;
			} else {
				tab[k] = rightTab[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			tab[k] = leftTab[i];
			i++;
			k++;
		}

		while (j < n2) {
			tab[k] = rightTab[j];
			j++;
			k++;
		}
	}

}