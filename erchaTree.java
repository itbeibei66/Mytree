package MyTree;

public class erchaTree {
    Node1 head;
    public erchaTree(){
        head=new Node1();
    }
    public void add(int x){
        Node1 cur=head;
        while(true){
                if(cur.key<x){
                    if(cur.right==null){
                        cur.right=new Node1(x);
                        return;
                    }
                    cur=cur.right;
                }else{
                    if(cur.left==null){
                        cur.left=new Node1(x);
                        return;
                    }
                    cur=cur.left;
                }

        }
    }
    public boolean find(int x){
        Node1 cur=head;
        while(cur!=null){
            if(x==cur.key){
                return true;
            }else if(x>cur.key){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return false;
    }
}
class Node1{
    int key;
    Node1 left;
    Node1 right;
    public Node1(){

    }
    public Node1(int x){
        key=x;
    }
}
