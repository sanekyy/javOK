package algorithm.eOlimp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ihb on 04.01.17.
 */
public class n518_A {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {

        int n = in.nextInt();

        for(int i=0; i<n; i++){
            out.println(in.nextInt() + in.nextInt());
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
        new n518_A().run();
    }
}
