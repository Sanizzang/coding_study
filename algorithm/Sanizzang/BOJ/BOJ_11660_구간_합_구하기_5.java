import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for(int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1];
            }
        }

        for(int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            if(x1 == x2 && y1 == y2) {
                sum += arr[x1][y1] - arr[x1][y1 - 1];
            }
            else {
                for(int j = x1;j <= x2;j++) {
                    sum += arr[j][y2] - arr[j][y1 - 1];
                }
            }

            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}