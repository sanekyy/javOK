package algorithm.eOlimp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ihb on 16.01.17.
 */
public class n2664_SimpleInsertSort {
    FastScanner in;
    PrintWriter out;

    public void solve() {

        int n = in.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }


        int key, i;
        for(int j = 1; j<n; j++){
            key = arr[j];
            i = j-1;
            while (i>=0 && arr[i] > key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
            if(i+1!=j){
                for(int k = 0; k<n; k++){
                    out.print(arr[k]+ " ");
                }
                out.println();
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
        new n2664_SimpleInsertSort().run();
    }
}
