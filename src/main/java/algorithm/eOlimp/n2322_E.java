package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n2322_E {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {

        int x = in.nextInt();
        int n = in.nextInt();

        int[] is = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(x==in.nextInt()) {
                    is[j] = 1;
                }
            }
        }

        for(int i=0; i<n;i++){
            if(is[i]==1){
                out.println("YES");
            } else {
                out.println("NO");
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

        String nextLine(){
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] arg) {
        new n2322_E().run();
    }
}
