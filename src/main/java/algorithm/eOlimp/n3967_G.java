package algorithm.eOlimp;

import java.io.*;
import java.util.*;

import static java.lang.Integer.MIN_VALUE;

/**
 * Created by ihb on 04.01.17.
 */
public class n3967_G {
    FastScanner in;
    PrintWriter out;

    public void solve() {

        int n, k;
        n = in.nextInt();
        k = in.nextInt();

        int[] cords = new int[n];
        int max = MIN_VALUE;
        long sum = 0;

        for(int i=0; i<n; i++){
            cords[i]=in.nextInt();
            sum+=cords[i];
            if(cords[i]>max)
                max=cords[i];
        }


        if(k>sum){
            out.print(0);
            return;
        }

        int step = 1;
        while(step<max){
            step*=2;
        }

        int count = 0;
        int length = max;

        for(int i=0; i<n; i++){
            count+=cords[i]/length;
        }


        while(true) {
            if (count < k) {
                while (count < k) {

                    if(length-step<=0)
                        break;

                    length -= step;
                    count = 0;

                    if (length == 0) {
                        break;
                    }

                    for (int i = 0; i < n; i++) {
                        count += cords[i] / length;
                    }

                }
                if(step == 1) {
                    out.print(length);
                    return;
                }
            } else {
                while (count >= k) {
                    length += step;
                    count = 0;

                    for (int i = 0; i < n; i++) {
                        count += cords[i] / length;
                    }
                }
                if(step == 1) {
                    out.print(length - 1);
                    return;
                }
            }

            step/=2;
        }

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
    }

    public static void main(String[] arg) throws Exception {
        new n3967_G().run();
    }
}
