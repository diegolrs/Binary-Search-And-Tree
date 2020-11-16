import java.util.StringTokenizer;

public class ATestando {
    public static void main(String[] args) {
        String[] k = {"lucas 22","frango 11","leite 77"};
        

        for(int i = 0; i < 3; i++) {
            StringTokenizer tmp = new StringTokenizer(k[i]);
            System.out.println(tmp.nextToken() + " " + tmp.nextToken());
        }
    }
}
