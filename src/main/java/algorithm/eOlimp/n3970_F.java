package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n3970_F {
    FastScanner in;
    PrintWriter out;

    public void solve() {

        int n;
        n = in.nextInt();
        int[] keys = new int[n];
        int[] values = new int[n];
        int size = 0;

        int key;
        int value;

        for (int i = 0; i < n; i++) {
            key = in.nextInt();
            boolean find = false;
            for(int j=0; j<size; j++){
                if(keys[j]==key){
                    find=true;
                    values[j]++;
                    break;
                }
            }

            if(!find){
                keys[size]=key;
                values[size++]=1;
            }
        }

        int m;
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            key = in.nextInt();
            value = 0;
            for (int j = 0; j < size; j++) {
                if (keys[j] == key) {
                    value = values[j];
                    break;
                }
            }
            out.println(value);
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

    public static void main(String[] arg) {
        new n3970_F().run();
    }
}
