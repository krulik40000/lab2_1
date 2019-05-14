/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Utility Class dla wyszukiwania binarnego
 *
 */
public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) {

        if (seq.length == 0) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = seq.length - 1;
        int center;
        int i = 2, ratio1, ratioI;
        SearchResult result = new SearchResult();

        if (seq.length > 2) {
            ratio1 = seq[1] - seq[0];
            do {
                ratioI = seq[i] - seq[i - 1];
                if (ratio1 != ratioI)
                    throw new IllegalArgumentException();
                i++;
            }
            while (i < seq.length);
        }

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center + 1);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }

        }
        return result;
    }

}
