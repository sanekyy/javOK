package algorithm.eOlimp;

import java.io.*;
import java.util.*;

import static java.lang.Integer.MIN_VALUE;

/**
 * Created by ihb on 04.01.17.
 */
public class n4039_K {
    FastScanner in;
    PrintWriter out;

    public void solve() {
        int n = in.nextInt();
        int[] all = new int[n];

        int command;
        int item;
        int size = 0;

        for(int i=0; i<n; i++) {
            all[i] = MIN_VALUE;
            command = in.nextInt();
            if(command == 0) {
                item = in.nextInt();
                if(size > 0 && item > all[size-1]){
                    all[size]=item;
                    size++;
                } else {
                    int it = binarySearch(all, size-1, item);
                    System.arraycopy(all, it, all, it + 1, size - it);
                    all[it] = item;
                    size++;
                }
            } else {
                out.println(all[size-1]);
                all[--size]=MIN_VALUE;
            }
        }
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
        new n4039_K().run();
    }
}
