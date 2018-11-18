import java.util.Arrays;
/**
 * Class for lsd.
 */
public class LSD {

    /**
     * Constructs the object.
     */
    protected LSD() {

    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      w     { parameter_description }
     */
    public static void sort(final String[] a, final int w) {
        int n = a.length;
        final int radix = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[radix + 1];
            for (int i = 0; i < n; i++) {
                // System.out.println(a[i].charAt(d));
                count[a[i].charAt(d) + 1]++;
                // System.out.println(Arrays.toString(count));
            }

            // compute cumulates
            for (int r = 0; r < radix; r++) {
                count[r + 1] += count[r];
            }

            // move data
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
