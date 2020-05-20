import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KumanovskiDijalekt {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        CBHT<String,String> recnik=new CBHT<>(N+N/4);
        for(int i=0;i<N;i++){
            String[] zborovi=br.readLine().split(" ");
            recnik.insert(zborovi[0],zborovi[1]);
        }
        boolean prvaBukva=false,znak=false;
        char znakk='.';
        String[] text=br.readLine().split(" ");
        String result="";
        for(int i=0;i<text.length;i++){
            String proverka=text[i];
            if(proverka.charAt(0)>='A'&&proverka.charAt(0)<='Z') {
                proverka = text[i].toLowerCase();
                prvaBukva=true;
            }
            if (proverka.endsWith(".")||proverka.endsWith("!")||proverka.endsWith("?")||proverka.endsWith(",")){
                proverka = proverka.substring(0,proverka.length()-1);
                znak=true;
                znakk=proverka.charAt(proverka.length()-1);
            }
            //System.out.println(proverka);
            SLLNode<MapEntry<String,String>> pom=recnik.search(proverka);
            if (pom==null){
               // System.out.println("pom==null : "+text[i]);
                result+=(text[i]+" ");
            }else {
                String newWord=pom.element.value;
                //System.out.println("pom!=null [nesmenet]: "+newWord);
                if (prvaBukva) {
                    String s1=newWord.substring(0,1).toUpperCase();
                    String s2=s1+newWord.substring(1);
                    newWord=s2;
                }

                if (znak)
                    newWord+=znakk;
               // System.out.println("pom!=null [smenet]: "+newWord);
                result+=(newWord+" ");

            }
            prvaBukva=false;
            znak=false;

        }
        System.out.println(result);
    }
}
