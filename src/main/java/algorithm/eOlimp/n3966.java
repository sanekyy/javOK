package algorithm.eOlimp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ihb on 04.01.17.
 */
public class n3966 {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n;
        n = in.nextInt();
        int[] all = new int[n];
        for(int i=0; i<n; i++){
            all[i]=in.nextInt();
        }

        n=in.nextInt();
        int[] search = new int[n];

        for(int i=0; i<n; i++){
            search[i] = in.nextInt();
        }

        for(int i=0; i<n; i++) {
            if(Arrays.binarySearch(all, search[i])<0){
                out.println("NO");
            } else {
                out.println("YES");
            }
        }

    }

    public void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(new OutputStreamWriter(System.out));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }

    public static void main(String[] arg) {
        new n3966().run();
    }
}
