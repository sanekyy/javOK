package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n1586_H {
    FastScanner in;
    PrintWriter out;

    public class MyStack {
        int[] stack;
        int size;

        MyStack(int len){
            stack = new int[len];
            size = 0;
        }

        void push(int item){
            stack[size++]=item;
        }

        int pop(){
            return stack[--size];
        }


    }

    public void solve() {

        String[] items = in.nextLine().split(" ");

        MyStack stack = new MyStack(items.length);

        for(String item : items){
            switch (item){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    stack.push(1/(stack.pop()/stack.pop()));
                    break;
                default:
                    stack.push(Integer.valueOf(item));
            }
        }

        out.print(stack.pop());
    }


    int pop(int[] stack){
        return 0;
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
        new n1586_H().run();
    }
}
