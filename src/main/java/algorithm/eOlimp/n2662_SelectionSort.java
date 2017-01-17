package algorithm.eOlimp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ihb on 16.01.17.
 */
public class n2662_SelectionSort {
    FastScanner in;
    PrintWriter out;

    public void solve() {
        int counter = 0;
        int currentIndex = 0;

        int n = in.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        for (int min=0;min<arr.length-1;min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }

            
            if(min == currentIndex && min!= least){
                counter++;
                currentIndex = least;
            } else if(least == currentIndex && min!= least){
                counter++;
                currentIndex = min;
            }

            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }


        out.println(counter);
    }

    public int binarySearch(int[] a, int high, int key){
        int low = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return low;  // key not found.
    }

    public void run() {
        in = new FastScanner();
        out = new PrintWriter(new OutputStreamWriter(System.out));

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] arg) {
        new n2662_SelectionSort().run();
    }
}
