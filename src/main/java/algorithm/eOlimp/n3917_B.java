package algorithm.eOlimp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ihb on 04.01.17.
 */
public class n3917_B {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {

        int a = in.nextInt();

        double n = Math.sqrt(a);

        if(a==2){
            out.print("True");
            return;
        }

        if(a%2==0){
            out.print("False");
            return;
        }

        for(int i=3; i<=n; i+=2){
            if(a%i==0){
                out.print("False");
                return;
            }
        }

        out.print("True");

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
        new n3917_B().run();
    }
}
