import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        CBHT<String,String> tabela=new CBHT<>(99);

        for(int i=0;i<N;i++){
            String[] vnes=br.readLine().split(" ");
            tabela.insert(vnes[0],vnes[1]);
        }

        while (true){
            String[] vnes=br.readLine().split(" ");

            if(vnes[0].equals("KRAJ"))
                break;

            SLLNode<MapEntry<String,String>> tmp=tabela.search(vnes[0]);

            if (tmp==null)
                System.out.println("Nenajaven");
            else {
                if(tmp.element.value.equals(vnes[1])){
                    System.out.println("Najaven");
                    break;
                }else {
                    System.out.println("Nenajaven");
                }
            }
        }


    }
}
