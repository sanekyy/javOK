package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n1459_D {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {

        int n = in.nextInt();


        int min1 = in.nextInt();
        int min2 = in.nextInt();

        if(min1>min2){
            int temp = min2;
            min2 = min1;
            min1 = temp;
        }

        for(int i=2; i<n; i++){
            int temp = in.nextInt();
            if(temp < min1){
                min2 = min1;
                min1 = temp;
            } else if(temp < min2){
                min2 = temp;
            }
        }

        out.print(min1 + " " + min2);
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
        new n1459_D().run();
    }
}
