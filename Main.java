import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //object creation for BST class
      BST o=new BST();
      int n=sc.nextInt();
      for(int i=0;i<n;i++)
      o.insert(sc.nextInt());
     System.out.print("Inorder :");
     o.inOrder(o.Realroot);
      System.out.println();
     System.out.print("preorder :");
      o.preOrder(o.Realroot);
       System.out.println();
     System.out.print("postorder :");
      o.postOrder(o.Realroot);
       System.out.println();
  }
}
//structure of each node
class node{
  int data;
  node left,right;
  node(int key){
    data=key;
    left=right=null;
  }
}
//BINARY SEARCH TREE CLASS
class BST{
    //original Root declaration
    node Realroot;
    ////normal insert method to avoid unwanted error for backtrack
    void insert(int key){
        //calling recursive insert method and reassigning root again
        Realroot=insertRecursively(Realroot,key);
    }
    //recursive insert method 
    node insertRecursively(node dupRoot,int key){
    //condtion for creating new node 
        if(dupRoot==null){
            return new node(key);
        }
    //condition for right side insertion  
        else if(key>dupRoot.data){
    //calling recursive insert but this time with dupRoot->right as dupRoot
            dupRoot.right=insertRecursively(dupRoot.right,key);
        }
         //condition for left side insertion  
       else if(key<dupRoot.data){
    //calling recursive insert but this time with dupRoot->left as dupRoot
            dupRoot.left=insertRecursively(dupRoot.left,key);
        }
    //return for original Root
        return dupRoot;
    }
//inOrder traversal
    void inOrder(node Root){
        if(Root!=null){
            //traversing till left end
            inOrder(Root.left);
            //printing data
            System.out.print(Root.data+" ");
            //traversing till right side end
            inOrder(Root.right);
        }
       
    }
//preOrder traversal
    void preOrder(node Root){
        if(Root!=null){
             //printing data
             System.out.print(Root.data+" ");
              //traversing till left end
            inOrder(Root.left);
              //traversing till right side end
            inOrder(Root.right);
        }
    }
    //postOrder traversal
    void postOrder(node Root){
        if(Root!=null){
             //traversing till left end
            inOrder(Root.left);
              //traversing till right side end
            inOrder(Root.right);
             //printing data
             System.out.print(Root.data+" ");
        }
    }
}
