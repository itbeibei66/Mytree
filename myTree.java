package MyTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class myTree {
    Node[] head;
    //初始化根节点数组
    public myTree(){
        head = new Node[10];
        for(int i=0 ; i<head.length ; i++){
            head[i] = new Node();
        }
    }
    //添加数据主方法
    public void add(int x){
        String s=Integer.toString(x);
        add(x,head[s.length()-1],0,s);
    }
    //添加数据
    public void add(int x , Node t , int talg , String s) {
        Node cur = t;
        for (int i = talg; i < s.length(); i++) {
            int c = s.charAt(i) - 48;
            if (cur.son != null) {
                if (cur.son[c] == null) {
                    cur.son[c] = new Node(x);
                    return;
                } else {
                    if (x > cur.son[c].key) {
                        cur = cur.son[c];
                    } else if(x<cur.son[c].key) {
                        int y = cur.son[c].key;
                        String yy = Integer.toString(y);
                        cur.son[c].key = x;
                        add(y, cur.son[c], i + 1, yy);
                        return;
                    }else{
                        cur = cur.son[c];
                        if(i==s.length()-1){
                            i--;
                        }
                    }
                }
            } else {
                cur.son = new Node[10];
                cur.son[c] = new Node(x);
                return;
            }
        }
    }
    //寻找数据
    public boolean search(int x){
        String temp=Integer.toString(x);
        Node cur=head[temp.length()-1];
        for(int i=0;i<temp.length();i++){
            int c=temp.charAt(i)-48;
            if(cur.son==null){
                return false;
            }else{
                if(cur.son[c]==null){
                    return false;
                }else{
                    if(cur.son[c].key==x){
                        return true;
                    }else if(cur.son[c].key>x){
                        return false;
                    }else{
                        cur=cur.son[c];
                    }
                }
            }
        }
        return false;
    }
    //随机删除
    public boolean delete(int x){
        String temp=Integer.toString(x);
        Node cur=head[temp.length()-1];
        for(int i=0;i<temp.length();i++){
            int c=temp.charAt(i)-48;
            if(cur.son==null){
                return false;
            }else{
                if(cur.son[c]==null){
                    return false;
                }else{
                    if(cur.son[c].key==x){
                        up(cur,cur.son[c],c);
                        return true;
                    }else if(cur.son[c].key>x){
                        return false;
                    }else{
                        cur=cur.son[c];
                    }
                }
            }
        }
        return false;
    }
    //移除最小元素
    public int pollFirst(){
        int key=-1;
        for(int i=0;i<10;i++){
            Node p=head[i];
            if(p.son!=null){
                for(int j=0;j<p.son.length;j++){
                    if(p.son[j]!=null){
                        key=p.son[j].key;
                        up(p,p.son[j],j);
                        return key;
                    }
                }
            }
        }
        return key;
    }
    //移除最大元素
    public int pollLast(){
        int key=-1;
        for(int i=9;i>=0;i--){
            Node p=head[i];
            if(p.son!=null){
                for(int j=p.son.length-1;j>=0;j--){
                    if(p.son[j]!=null){
                        return down(p,p.son[j],j);
                    }
                }
            }
        }
        return key;
    }
    //向下递归找最大元素
    public int down(Node p,Node cur,int c){
        if(cur.son!=null){
            for(int i=cur.son.length-1;i>=0;i--){
                if(cur.son[i]!=null){
                    return down(cur,cur.son[i],i);
                }
            }
        }
        int key=cur.key;
        cur=null;
        p.son[c]=null;
        return key;
    }
    //数据上移动
    public void up(Node p,Node cur,int c){
        if(cur.son==null){
            cur=null;
            p.son[c]=null;
        }else{
            for(int i=0;i<cur.son.length;i++){
                if(cur.son[i]!=null){
                    cur.key=cur.son[i].key;
                    up(cur,cur.son[i],i);
                    return;
                }
            }
            cur=null;
            p.son[c]=null;
        }
    }
    //深度优先
    public void dfs(Node p,ArrayList<Integer> list){
        if(p.son!=null){
            for(int i=0;i<p.son.length;i++){
                if(p.son[i]!=null){
                    if(p.son[i].key>-1){
                        list.add(p.son[i].key);
                    }
                    dfs(p.son[i],list);
                }
            }
        }
    }
    //深度优先遍历，返回一个集合
    public ArrayList<Integer> dfs(){
        ArrayList<Integer> list=new ArrayList<>(100000);
        for(int i=0;i<10;i++){
            Node p=head[i];
            dfs(p,list);
        }
        return list;
    }
    //广度优先遍历，返回一个集合
    public ArrayList<Integer> bfs(){
        LinkedList<Node> list=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>(100000);
        for(int p=0;p<10;p++){
            list.add(head[p]);
            while(!list.isEmpty()){
                int a=list.size();
                for(int i=0;i<a;i++){
                    Node temp=list.poll();
                    int k=temp.key;
                    if(temp!=head[p]&&k>-1){
                        res.add(k);
                    }
                    if(temp.son!=null){
                        for(int j=0;j<temp.son.length;j++){
                            if(temp.son[j]!=null){
                                list.add(temp.son[j]);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
class Node{
    int key;
    Node[] son;
    public Node(){

    }
    public Node(int x){
        key=x;
    }
}
