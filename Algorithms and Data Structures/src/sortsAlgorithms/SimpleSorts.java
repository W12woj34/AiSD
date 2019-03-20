package sortsAlgorithms;

import java.util.ArrayList;

public class SimpleSorts {

	SimpleSorts() {

	}

	public void BucketSort(Integer[] tab) {

		int rozmiarKoszyka = 1000;
		if (tab.length == 0) {
			return;
		}

		int MAX = tab[0];
		int MIN = tab[0];

		for (int i = 0; i < tab.length; i++) {

			if (tab[i] < MIN) {

				MIN = tab[i];

			} else if (tab[i] > MAX) {

				MAX = tab[i];

			}
		}

		MIN = Math.abs(MIN);
		MAX = MAX + MIN;

		for (int i = 0; i < tab.length; i++) {

			tab[i] = tab[i] + MIN;

		}

		int iloscKoszykow = MAX / rozmiarKoszyka + 1;
		ArrayList<ArrayList<Integer>> koszyki = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < iloscKoszykow; i++) {

			koszyki.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < tab.length; i++) {

			koszyki.get((tab[i]) / rozmiarKoszyka).add(tab[i]);
		}

		int indexPosortowanejTablicy = 0;

		for (int i = 0; i < koszyki.size(); i++) {

			Integer[] tablicaKoszykow = new Integer[koszyki.get(i).size()];
			tablicaKoszykow = koszyki.get(i).toArray(tablicaKoszykow);
			this.InsertionSort(tablicaKoszykow);

			for (int j = 0; j < tablicaKoszykow.length; j++) {

				tab[indexPosortowanejTablicy++] = tablicaKoszykow[j];
			}
		}

		for (int i = 0; i < tab.length; i++) {

			tab[i] = tab[i] - MIN;

		}

	}

	public void BubbleSort(Integer[] tab) {

		for (int i = tab.length - 1; i >= 0; i--) {

			for (int j = 1; j <= i; j++) {

				if (tab[j - 1] > tab[j]) {

					int temp = tab[j - 1];
					tab[j - 1] = tab[j];
					tab[j] = temp;

				}
			}
		}

	}

	public void InsertionSort(Integer[] tab) {

		for (int i = 1; i < tab.length; i++) {
			int index = tab[i];
			int j = i;

			for (; j > 0 && tab[j - 1] > index; j--) {

				tab[j] = tab[j - 1];
			}
			tab[j] = index;
		}

	}

	public void SelectionSort(Integer[] tab) {

		for (int i = 0; i < tab.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < tab.length; j++) {

				if (tab[j] < tab[min]) {
					min = j;
				}
			}

			int temp = tab[i];
			tab[i] = tab[min];
			tab[min] = temp;
		}
	}

}
