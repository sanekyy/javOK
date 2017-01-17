package algorithm.eOlimp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ihb on 16.01.17.
 */
public class n4848_QuickSort {
    FastScanner in;
    PrintWriter out;

    public void solve() {
        String[] numbers = in.nextLine().trim().split(" ");

        int n = numbers.length;

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.valueOf(numbers[i]);
        }

        sort(arr);

        for(long item : arr){
            out.print(item + " ");
        }

    }

    public static void qSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int x = arr[low+(high-low)/2];
        do {
            while(arr[i] < x) ++i;
            while(arr[j] > x) --j;
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i ++ ; j --;
            }
        } while(i <= j);
        if(low < j) qSort(arr, low, j);
        if(i < high) qSort(arr, i, high);
    }


    private static int heapSize;

    public static void sort(int[] arr) {
        buildHeap(arr);
        while (heapSize > 1) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        heapSize = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && arr[i] < arr[l]) {
            largest = l;
        }
        if (r < heapSize && arr[largest] < arr[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 1;
    }


    private static int left(int i) {
        return 2 * i + 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
