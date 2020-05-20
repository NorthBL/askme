import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        CBHT<String,Integer> tabela=new CBHT<>(9999);
        String zbor=br.readLine();
        String najcest=null;
        int pojavi=0;
        for (int i=1;i<=zbor.length();i++){
            for (int j=0;j<zbor.length()-i+1;j++){
                //System.out.println(zbor.substring(j,j+i));
                String podstring=zbor.substring(j,j+i);
                SLLNode<MapEntry<String,Integer>> pom=tabela.search(podstring);
                if(pom==null){
                    tabela.insert(podstring,1);
                    if(pojavi<1){
                        najcest=podstring;
                        pojavi=1;
                    }else if(pojavi==1){
                        if(najcest.compareTo(podstring)<0)
                            najcest=podstring;
                        if (najcest.compareTo(podstring)==0){
                            if(najcest.length()<podstring.length())
                                najcest=podstring;
                        }
                    }
                }else {
                    tabela.insert(podstring,pom.element.value+1);
                    if(pojavi<tabela.search(podstring).element.value){
                        najcest=podstring;
                        pojavi=tabela.search(podstring).element.value;
                    }else if (pojavi==tabela.search(podstring).element.value){
                        if(najcest.compareTo(podstring)<0)
                            najcest=podstring;
                        if (najcest.compareTo(podstring)==0){
                            if(najcest.length()<podstring.length())
                                najcest=podstring;
                        }
                    }
                }
            }
        }

        System.out.println(najcest);
    }
}
