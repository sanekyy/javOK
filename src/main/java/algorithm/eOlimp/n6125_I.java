package algorithm.eOlimp;

import java.io.*;
import java.util.*;

/**
 * Created by ihb on 04.01.17.
 */
public class n6125_I {
    FastScanner in;
    PrintWriter out;

    public class MyArrayDeque {
        int[] stack;
        int size = 0;
        int left = 0;
        int right = 0;


        MyArrayDeque(int len){
            stack = new int[len];
        }

        void push(int item){
            stack[right++]=item;
            size++;
        }

        int pop(){
            size--;
            return stack[left++];
        }

        int front(){
            return stack[left];
        }

        int size(){
            return size;
        }


        public void clear() {
            while(size>0){
                pop();
            }
        }
    }

    public void solve() {
        MyArrayDeque deque = new MyArrayDeque(100000);
        while(true){
            switch (in.next()){
                case "push":
                    deque.push(in.nextInt());
                    out.println("ok");
                    break;
                case "pop":
                    out.println(deque.pop());
                    break;
                case "front":
                    out.println(deque.front());
                    break;
                case "size":
                    out.println(deque.size());
                    break;
                case "clear":
                    deque.clear();
                    out.println("ok");
                    break;
                case "exit":
                    out.println("bye");
                    return;
            }
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
        new n6125_I().run();
    }
}
