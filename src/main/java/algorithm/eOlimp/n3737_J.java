package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n3737_J {
    FastScanner in;
    PrintWriter out;

    public void solve() {
        int size=in.nextInt();
        long A[]=new long[size];
        boolean check=true;
        for(int i=1;i<size;i++){
            A[i]=in.nextLong();
        }

        for(int i=1;i<size/2;i++){
            if(i*2<size) {
                if (A[i] > A[i * 2])
                    check = false;
                if(i*2+1<size)
                    if(A[i]>A[i*2+1])
                        check=false;
            }
        }
        if(check)
            System.out.println("YES");
        else System.out.println("NO");
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
        new n3737_J().run();
    }
}
