package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n3920_C {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {

        String[] strings = in.nextLine().split(" ");

        int n = strings.length;

        int[] all = new int[n];

        for(int i=0; i<n; i++){
            all[i] = Integer.valueOf(strings[i]);
        }

        Arrays.sort(all);

        boolean isNod = true;
        for(int i=0; i<n; i++){
            if(all[i]%all[0]!=0){
                isNod = false;
                break;
            }
        }
        if(isNod){
            out.print(all[0]);
            return;
        }




        for(int i=1; true; i++){
            if(all[0]%i!=0)
                continue;

            int current = all[0]/i;
            isNod = true;
            for(int a : all){
                if(a%current!=0){
                    isNod = false;
                    break;
                }
            }
            if(isNod){
                out.print(current);
                return;
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
        new n3920_C().run();
    }
}
