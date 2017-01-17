package algorithm.eOlimp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ihb on 16.01.17.
 */
public class n4037_MergeSort {
    FastScanner in;
    PrintWriter out;

    class Robot{
        int f;
        int s;

        Robot(int f, int s){
            this.f = f;
            this.s = s;
        }

    }

    public void solve() {
        int n = in.nextInt();

        Robot[] arr = new Robot[n];

        for(int i=0; i<n; i++){
            arr[i] = new Robot(in.nextInt(), in.nextInt());
        }

        sortMerge(arr);

        for(Robot item : arr){
            out.println(item.f + " " + item.s);
        }

    }

    private static Robot[] sortMerge(Robot[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static Robot[] merge(Robot[] arr_1, Robot[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        Robot[] result = new Robot[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a].f > arr_2[b].f) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
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
        new n4037_MergeSort().run();
    }
}
