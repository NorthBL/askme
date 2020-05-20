import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InorderSuccessor {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        BinarySearchTree<Integer> tree=new BinarySearchTree<>();

        for (int i=0;i<N;i++){
            tree.insert(Integer.parseInt(br.readLine()));
        }

        ReseniInorderSuccessor ris=new ReseniInorderSuccessor(tree);
       // ris.successor(Integer.parseInt(br.readLine()));
        ris.inorderr();
    }
}
