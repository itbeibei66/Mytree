package MyTree;

import java.util.ArrayList;
import java.util.LinkedList;
@SuppressWarnings("all")
public class MyTreeLast<V>{

    //函数式编程调用方法
    private  int  method(V v,MyTreeLastFunction my){
        return my.call(v);
    }

    Node3[] head;

    private  MyTreeLastFunction<? super V> feek = null;

    public MyTreeLastFunction<? super V> myTreeLastFunction() {
        return feek;
    }

    //初始化根节点数组
    public MyTreeLast(){
        head = new Node3[20];
        for(int i=0 ; i<head.length ; i++){
            head[i] = new Node3();
        }
    }

    //返回接口
    public MyTreeLast(MyTreeLastFunction<? super V> feek) {
        head = new Node3[20];
        for(int i=0 ; i<head.length ; i++){
            head[i] = new Node3();
        }
        this.feek = feek;
    }

    //添加数据主方法(不去重)
    public void add(V v){
        int x;
        if(v.getClass()==Integer.class){
            x=(Integer) v;
        }else{
            x=method(v,feek);
        }
        String s = Integer.toString(Math.abs(x));
        ArrayList<V> list=new ArrayList<>();
        list.add(v);
        if(x>=0){
            add(list ,x ,head[s.length()+9] ,0 , s ,false);
        }else{
            add(list ,x ,head[10-s.length()],0, s ,false);
        }

    }

    //添加数据主方法(可选去重)
    public void add(V v,boolean f){
        int x=method(v,feek);
        String s = Integer.toString(Math.abs(x));
        ArrayList<V> list=new ArrayList<>();
        list.add(v);
        if(x>=0){
            add(list , x ,head[s.length()+9] ,0 , s , f);
        }else{
            add(list , x,head[10-s.length()],0, s , f);
        }

    }

    //添加数据
    public void add(ArrayList<V> v, int x , Node3 t , int talg , String s,boolean f) {
        Node3 cur = t;
        for (int i = talg; i < s.length(); i++) {
            int c = s.charAt(i) - 48;
            if (cur.son != null) {
                if (cur.son[c] == null) {
                    cur.son[c] = new Node3(x);
                    cur.son[c].list.addAll(v);
                    return;
                } else {
                    if (x > (int)cur.son[c].key) {
                        cur = cur.son[c];
                    } else if(x < (int)cur.son[c].key) {
                        int y = (int)cur.son[c].key;
                        ArrayList<V> list=cur.son[c].list;
                        String yy = Integer.toString(Math.abs(y));
                        cur.son[c].key = x;
                        cur.son[c].list= v;
                        add(list, y, cur.son[c], i + 1, yy ,f);
                        return;
                    }else{
                        if(!f){
                            cur.son[c].list.addAll(v);
                        }
                        return;
                    }
                }
            } else {
                cur.son = new Node3[10];
                cur.son[c] = new Node3(x);
                cur.son[c].list.addAll(v);
                return;
            }
        }
    }

    //寻找数据
    public boolean search(V v){
        int x=method(v,feek);

        String temp = Integer.toString(x);
        Node3 cur;
        if(x>=0){
            cur=head[temp.length()+9];
        }else{
            temp=temp.substring(1,temp.length());
            cur=head[10-temp.length()];
        }
        for(int i=0; i<temp.length(); i++){
            int c = temp.charAt(i)-48;
            if(cur.son == null){
                return false;
            }else{
                if(cur.son[c] == null){
                    return false;
                }else{
                    if((int)cur.son[c].key == x){
                        for(Object v1:cur.son[c].list){
                            if((V)v1==v){
                                return true;
                            }
                        }
                        return false;
                    }else if((int)cur.son[c].key > x){
                        return false;
                    }else{
                        cur = cur.son[c];
                    }
                }
            }
        }
        return false;
    }

    //删除某个指定元素
    public boolean delete(V v){
        int x=method(v,feek);
        String temp = Integer.toString(x);
        Node3 cur;
        if(x>=0){
            cur=head[temp.length()+9];
        }else{
            temp=temp.substring(1,temp.length());
            cur=head[10-temp.length()];
        }
        for(int i = 0;i < temp.length(); i++){
            int c = temp.charAt(i)-48;
            if(cur.son == null){
                return false;
            }else{
                if(cur.son[c] == null){
                    return false;
                }else{
                    if((int)cur.son[c].key == x){
                        for(Object o:cur.son[c].list){
                            if((V)o==v){
                                cur.son[c].list.remove(v);
                                break;
                            }
                        }
                        if(cur.son[c].list.size()==0){
                            boolean f=x<0?true:false;
                            up(cur,cur.son[c],c,f);
                        }
                        return true;
                    }else if((int)cur.son[c].key > x){
                        return false;
                    }else{
                        cur = cur.son[c];
                    }
                }
            }
        }
        return false;
    }

    //移除最小元素
    public V pollFirst(){
        V v=null;
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node3 p = head[i];
            if(p.son != null){
                if(i<=9){
                    falg = true;
                    for(int j=p.son.length-1; j > 0; j--){
                        if(p.son[j] != null){
                            v=(V)p.son[j].list.get(p.son[j].list.size()-1);
                            p.son[j].list.remove(p.son[j].list.size()-1);
                            if(p.son[j].list.size()==0){
                                up(p, p.son[j], j, falg);
                            }
                            return v;
                        }
                    }
                }else{
                    falg = false;
                    for(int j = 0;j < p.son.length; j++){
                        if(p.son[j] != null){
                            v=(V)p.son[j].list.get(p.son[j].list.size()-1);
                            p.son[j].list.remove(p.son[j].list.size()-1);
                            if(p.son[j].list.size()==0){
                                up(p, p.son[j], j, falg);
                            }
                            return v;
                        }
                    }
                }

            }
        }
        return v;
    }

    //获取最小元素
    public V peekFirst(){
        V v= null;
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node3 p = head[i];
            if(p.son != null){
                if(i<=9){
                    falg = true;
                    for(int j=p.son.length-1; j > 0; j--){
                        if(p.son[j] != null){
                            v=(V)p.son[j].list.get(p.son[j].list.size()-1);
                            return v;
                        }
                    }
                }else{
                    falg = false;
                    for(int j = 0;j < p.son.length; j++){
                        if(p.son[j] != null){
                            v=(V)p.son[j].list.get(p.son[j].list.size()-1);
                            return v;
                        }
                    }
                }

            }
        }
        return v;
    }

    //数据上移动
    public void up(Node3 p,Node3 cur,int c,boolean falg){
        if(cur.son == null){
            cur = null;
            p.son[c] = null;
        }else{
            if(falg){
                for(int i = cur.son.length-1; i>=0; i--){
                    if(cur.son[i] != null){
                        cur.key = cur.son[i].key;
                        cur.list = cur.son[i].list;
                        up( cur, cur.son[i], i,falg);
                        return;
                    }
                }

            }else{
                for(int i = 0;i < cur.son.length; i++){
                    if(cur.son[i] != null){
                        cur.key = cur.son[i].key;
                        cur.list = cur.son[i].list;
                        up( cur, cur.son[i], i,falg);
                        return;
                    }
                }
            }
            cur = null;
            p.son[c] = null;
        }
    }

    //移除最大元素
    public V pollLast(){
        V v = null;
        boolean falg;
        for(int i = 19;i >= 0; i--){
            Node3 p = head[i];
            if(p.son != null){
                if(i>=10){
                    falg=false;
                    for(int j = p.son.length-1; j >= 0; j--){
                        if(p.son[j] != null){
                            return down( p, p.son[j], j, falg, true);
                        }
                    }
                }else{
                    falg=true;
                    for(int j = 0; j < p.son.length; j++){
                        if(p.son[j] != null){
                            return down( p, p.son[j], j, falg, true);
                        }
                    }
                }

            }
        }
        return v;
    }

    //获取最大元素
    public V peekLast(){
        V v = null;
        boolean falg;
        for(int i = 19;i >= 0; i--){
            Node3 p = head[i];
            if(p.son != null){
                if(i>=10){
                    falg=false;
                    for(int j = p.son.length-1; j >= 0; j--){
                        if(p.son[j] != null){
                            return down( p, p.son[j], j, falg, false);
                        }
                    }
                }else{
                    falg=true;
                    for(int j = 0; j < p.son.length; j++){
                        if(p.son[j] != null){
                            return down( p, p.son[j], j, falg, false);
                        }
                    }
                }

            }
        }
        return v;
    }

    //向下递归找最大元素
    public V down(Node3 p,Node3 cur,int c,boolean falg,boolean f){
        if(cur.son != null){
            if(falg){
                for(int i=0 ; i < cur.son.length ; i++){
                    if(cur.son[i] != null){
                        return down( cur, cur.son[i], i,falg, f);
                    }
                }
            }else{
                for(int i = cur.son.length-1; i >= 0; i--){
                    if(cur.son[i] != null){
                        return down( cur, cur.son[i], i,falg,f);
                    }
                }
            }
        }
        V v = (V)cur.list.get(cur.list.size()-1);
        if(f){
            cur.list.remove(cur.list.size()-1);
            if(cur.list.size()==0){
                cur = null;
                p.son[c] = null;
            }
        }
        return v;
    }

    //深度优先
    public void dfs(Node3 p, ArrayList<V> list, boolean falg){
        if(p.son != null){
            if(falg){
                for(int i = p.son.length-1;i >= 0; i--){
                    if(p.son[i] != null){
                        list.addAll(p.son[i].list);
                        dfs( p.son[i], list, falg);
                    }
                }
            }else{
                for(int i = 0;i < p.son.length; i++){
                    if(p.son[i] != null){
                        list.addAll(p.son[i].list);
                        dfs( p.son[i], list, falg);
                    }
                }
            }

        }
    }

    //深度优先遍历，返回一个集合(深度遍历，可返回完全有序的集合)
    public ArrayList<V> dfs(){
        ArrayList<V> list = new ArrayList<>(100000);
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node3 p = head[i];
            if(i<=9){
                falg = true;
            }else{
                falg = false;
            }
            dfs(p, list, falg);
        }
        return list;
    }

    @Deprecated
    //广度优先遍历，返回一个集合(没什么实质性用处，返回的集合不一定有序，只是大致有序)
    public ArrayList<V> bfs(){
        LinkedList<Node3> list = new LinkedList<>();
        ArrayList<V> res = new ArrayList<>(100000);
        boolean falg;
        for(int p = 0 ; p < 20 ; p++){
            if(p<10){
                falg = true;
            }else{
                falg = false;
            }
            list.add(head[p]);
            while(!list.isEmpty()){
                int a = list.size();
                for(int i = 0; i < a; i++){
                    Node3 temp = list.poll();
                    if(temp != head[p]){
                        res.addAll(temp.list);
                    }
                    if(temp.son != null){
                        if(falg){
                            for(int j = temp.son.length-1; j >= 0; j--){
                                if(temp.son[j] != null){
                                    list.add(temp.son[j]);
                                }
                            }
                        }else{
                            for(int j = 0; j < temp.son.length; j++){
                                if(temp.son[j] != null){
                                    list.add(temp.son[j]);
                                }
                            }
                        }

                    }
                }
            }
        }
        return res;
    }



}
class Node3<K,V>{
    K key;
    Node3[] son;
    ArrayList<V> list;
    public Node3(){

    }
    public Node3(K k){
        key = k;
        list=new ArrayList<>();
    }

}