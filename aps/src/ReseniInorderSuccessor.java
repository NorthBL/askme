public class ReseniInorderSuccessor {
    BinarySearchTree<Integer> tree;
    String traversal="";

    public ReseniInorderSuccessor(BinarySearchTree<Integer> tree) {
        this.tree = tree;
    }

    private void inorder(BNode<Integer> node){
        if(node!=null){
            this.inorder(node.left);
            this.traversal+=(node.info+" ");
            this.inorder(node.right);
        }
    }

    public void successor(int koj){
        this.inorder(this.tree.getRoot());
        String[] clenovi=traversal.split(" ");
        for (int i=0;i<clenovi.length-1;i++){
            if(clenovi[i].equals(Integer.toString(koj))){
                System.out.println(clenovi[i+1]);
                return;
            }
        }
    }

    public void inorderr(){
        this.inorder(this.tree.getRoot());
        System.out.println(traversal.replaceAll(" ","\n"));
    }
}
