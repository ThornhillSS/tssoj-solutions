import java.io.*;
import java.util.*;

public class Main {
  //We can do psa + monodeque to solve this problem.
    public static class Reader {
            private final int BUFFER_SIZE = 1 << 12;
            private int LENGTH = 100;
            private DataInputStream din;
            private byte[] buffer;
            private int bufferPointer, bytesRead;

            public Reader(InputStream inputStream) {
                din = new DataInputStream(inputStream);
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            }

            public Reader(String file_name) throws IOException {
                din = new DataInputStream(new FileInputStream(file_name));
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            }

            public int nextInt() throws IOException {
                int ans = 0;
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                boolean neg = (c == '-');
                if (neg) c = read();
                do {
                    ans = ans * 10 + c - '0';
                } while ((c = read()) >= '0');
                if (neg) return -ans;
                return ans;
            }

            public long nextLong() throws IOException {
                long ans = 0;
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                boolean neg = (c == '-');
                if (neg) c = read();
                do {
                    ans = ans * 10 + c - '0';
                } while ((c = read()) >= '0');
                if (neg) return -ans;
                return ans;
            }

            public double nextDouble() throws IOException {
                double ans = 0, div = 1;
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                boolean neg = (c == '-');
                if (neg) c = read();
                do {
                    ans = ans * 10 + c - '0';
                } while ((c = read()) >= '0');
                if (c == '.') while ((c = read()) >= '0') ans += (c - '0') / (div *= 10);
                if (neg) return -ans;
                return ans;
            }

            public char nextChar() throws IOException {
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                return (char) c;
            }

            public String next() throws IOException {
                byte[] buf = new byte[LENGTH];
                int cnt = 0;
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                do {
                    buf[cnt++] = c;
                } while ((c = read()) > ' ');
                return new String(buf, 0, cnt);
            }

            public String nextLine() throws IOException {
                byte[] buf = new byte[LENGTH];
                int cnt = 0;
                byte c;
                do {
                    c = read();
                } while (c <= ' ');
                do {
                    buf[cnt++] = c;
                } while ((c = read()) >= ' ');
                return new String(buf, 0, cnt);
            }

            public void setLength(int length) {
                LENGTH = length;
            }

            private void fillBuffer() throws IOException {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) buffer[0] = -1;
            }

            private byte read() throws IOException {
                if (bufferPointer == bytesRead) fillBuffer();
                return buffer[bufferPointer++];
            }

            public void close() throws IOException {
                if (din == null) return;
                din.close();
            }
        }

        private static Reader in;
        private static PrintWriter pr;
        private static final String INPUT_FILE_NAME = "input.txt";
        private static final String OUTPUT_FILE_NAME = "output.txt";
        private static boolean stdIn = true;
        private static boolean stdOut = true;
        private static boolean crash = true;
        private static boolean flush = false;
        public static void main(String[] args) throws Exception{
            if (stdIn) in = new Reader(System.in);
            else in = new Reader(INPUT_FILE_NAME);
            if (stdOut) pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            else pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME)));
            int n = in.nextInt(), k = in.nextInt(), arr[] = new int[n];
            for(int i = 0; i<n; i++)arr[i] = in.nextInt();
            long[]psa = new long[n+1];
            for(int i = 0; i<n; i++){
                psa[i+1] = psa[i]+(long)arr[i];
            }
            int ans = n+1;
            Deque<Integer>Q = new LinkedList<>();
            for(int i = 0; i<psa.length; i++){
                while(!Q.isEmpty()&&psa[i]<=psa[Q.getLast()]){
                    Q.removeLast();
                }
                while(!Q.isEmpty()&&psa[i]>=psa[Q.getFirst()]+k){
                    ans = Math.min(ans, i-Q.removeFirst());
                }
                Q.addLast(i);
            }
            if(ans<n+1)pr.println(ans);
            else pr.println(-1);
            pr.close();
        }
}
