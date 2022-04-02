package MyTree;
import java.util.ArrayList;
import java.util.LinkedList;
/*
author:此人似乎没有昵称哦
* */
@SuppressWarnings("all")
/**
 * 一种可以自动排序的数据结构：
 * 其功能包括：1.添加元素
 *           2.删除特定元素
 *           3.判断元素是否存在
 *           4.移除当前最小元素
 *           5.移除当前最大元素
 *           6.获取当前最小元素的值
 *           7.获取当前最大元素的值
 *           8.返回一个有序集合
 * 测试表明：
 *     当数据重复数较少时
 *     1.其添加效率高于TreeSet，在数据量巨大时（百万以上级别），添加效率是TreeSet2倍以上
 *     2.其查询效率高于TreeSet，在数据量巨大时（百万以上级别），添加效率是TreeSet2倍以上
 *     3.其删除指定元素的效率高于TreeSet，在数据量巨大时（百万以上级别），添加效率是TreeSet2倍以上
 *     4.其移除最小最大元素的效率低于TreeSet，在数据量巨大时，效率约为TreeSet的2/3
 *     5.其移除最大元素的速度优于移除最小元素
 *
 *     当数据重复数较大时
 *     1.其添加效率远高于TreeSet，在数据量巨大时(百万以上级别)，添加效率是TreeSet的数倍，
 *       在数据量特别巨大时(千万以上级别)，添加效率是TreeSet的十倍以上
 *     2.其查询效率远高于TreeSet，在数据量巨大时(百万以上级别)，查询效率是TreeSet的数倍，
 *  *    在数据量特别巨大时(千万以上级别)，查询效率是TreeSet的十倍以上，当要查询的元素远小于
 *       存储元素的平均值时，查询效率更快，可达TreeSet的几十倍
 *     3.其删除效率远高于TreeSet，在数据量巨大时(百万以上级别)，删除效率是TreeSet的数倍，
 *  *    在数据量特别巨大时(千万以上级别)，删除效率是TreeSet的十倍以上
 *     4.其移除最小最大元素的效率高于TreeSet，在数据量巨大时（百万以上级别），效率可达
 *       TreeSet的2倍以上
 * **/
public class myTreePlus {
    /**根节点数组，其容量在初始化时被设置为20，其中0-9号存储负数，10-19号存储正数
     * 具体存储情况, 0号存储位数为10位的负数
     *             1号存储位数为9位的负数
     *             2号存储位数为8位的负数
     *             3号存储位数为7位的负数
     *             ....
     *             9号存储位数为1位的负数
     *             10号存储位数为1位的正数
     *             11号存储位数为2位的正数
     *             12号存储位数为3位的正数
     *             ....
     *             19号存储位数为10位的正数
     *
     *             因为最大int型和最小int型数的长度10位，所以暂且只设计这么多位
     */
    Node2[] head;

    //初始化根节点数组
    public myTreePlus(){
        head = new Node2[20];
        for(int i=0 ; i<head.length ; i++){
            head[i] = new Node2();
        }
    }

    //添加数据主方法(不去重)
    public void add(int x){
        String s = Integer.toString(Math.abs(x));
        if(x>=0){
            add(x ,head[s.length()+9] ,0 , s ,1,false);
        }else{
            add(x,head[10-s.length()],0, s ,1,false);
        }

    }

    //添加数据主方法(去重)
    public void add(int x,boolean f){
        String s = Integer.toString(Math.abs(x));
        if(x>=0){
            add(x ,head[s.length()+9] ,0 , s ,1, f);
        }else{
            add(x,head[10-s.length()],0, s ,1, f);
        }

    }

    //添加数据
    public void add(int x , Node2 t , int talg , String s, int times,boolean f) {
        Node2 cur = t;
        for (int i = talg; i < s.length(); i++) {
            int c = s.charAt(i) - 48;
            if (cur.son != null) {
                if (cur.son[c] == null) {
                    cur.son[c] = new Node2(x,times);
                    return;
                } else {
                    if (x > cur.son[c].key) {
                        cur = cur.son[c];
                    } else if(x<cur.son[c].key) {
                        int y = cur.son[c].key;
                        int time = cur.son[c].times;
                        String yy = Integer.toString(Math.abs(y));
                        cur.son[c].key = x;
                        cur.son[c].times = times;
                        add(y, cur.son[c], i + 1, yy, time ,f);
                        return;
                    }else{
                        if(!f){
                            cur.son[c].times++;
                        }
                        return;
                    }
                }
            } else {
                cur.son = new Node2[10];
                cur.son[c] = new Node2(x,times);
                return;
            }
        }
    }

    //寻找数据
    public boolean search(int x){
        String temp = Integer.toString(x);
        Node2 cur;
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
                    if(cur.son[c].key == x){
                        return true;
                    }else if(cur.son[c].key > x){
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
    public boolean delete(int x){
        String temp = Integer.toString(x);
        Node2 cur;
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
                    if(cur.son[c].key == x){
                        if(cur.son[c].times > 1){
                            cur.son[c].times--;
                        }else{
                            boolean f=x<0?true:false;
                            up(cur,cur.son[c],c,f);
                        }
                        return true;
                    }else if(cur.son[c].key > x){
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
    public int pollFirst(){
        int key = -1;
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node2 p = head[i];
            if(p.son != null){
                if(i<=9){
                    falg = true;
                    for(int j=p.son.length-1; j > 0; j--){
                        if(p.son[j] != null){
                            key = p.son[j].key;
                            if(p.son[j].times > 1){
                                p.son[j].times--;
                            }else{
                                up(p, p.son[j], j, falg);
                            }
                            return key;
                        }
                    }
                }else{
                    falg = false;
                    for(int j = 0;j < p.son.length; j++){
                        if(p.son[j] != null){
                            key = p.son[j].key;
                            if(p.son[j].times > 1){
                                p.son[j].times--;
                            }else{
                                up(p, p.son[j], j, falg);
                            }
                            return key;
                        }
                    }
                }

            }
        }
        return key;
    }

    //获取最小元素
    public int peekFirst(){
        int key = -1;
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node2 p = head[i];
            if(p.son != null){
                if(i<=9){
                    falg = true;
                    for(int j=p.son.length-1; j > 0; j--){
                        if(p.son[j] != null){
                            key = p.son[j].key;
                            return key;
                        }
                    }
                }else{
                    falg = false;
                    for(int j = 0;j < p.son.length; j++){
                        if(p.son[j] != null){
                            key = p.son[j].key;
                            return key;
                        }
                    }
                }

            }
        }
        return key;
    }

    //数据上移动
    public void up(Node2 p,Node2 cur,int c,boolean falg){
        if(cur.son == null){
            cur = null;
            p.son[c] = null;
        }else{
            if(falg){
                for(int i = cur.son.length-1; i>=0; i--){
                    if(cur.son[i] != null){
                        cur.key = cur.son[i].key;
                        cur.times = cur.son[i].times;
                        up( cur, cur.son[i], i,falg);
                        return;
                    }
                }

            }else{
                for(int i = 0;i < cur.son.length; i++){
                    if(cur.son[i] != null){
                        cur.key = cur.son[i].key;
                        cur.times = cur.son[i].times;
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
    public int pollLast(){
        int key = -1;
        boolean falg;
        for(int i = 19;i >= 0; i--){
            Node2 p = head[i];
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
        return key;
    }

    //获取最大元素
    public int peekLast(){
        int key = -1;
        boolean falg;
        for(int i = 19;i >= 0; i--){
            Node2 p = head[i];
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
        return key;
    }

    //向下递归找最大元素
    public int down(Node2 p,Node2 cur,int c,boolean falg,boolean f){
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
        int key = cur.key;
        if(f){
            if(cur.times > 1){
                cur.times--;
            }else{
                cur = null;
                p.son[c] = null;
            }
        }
        return key;
    }

    //深度优先
    public void dfs(Node2 p, ArrayList<Integer> list, boolean falg){
        if(p.son != null){
            if(falg){
                for(int i = p.son.length-1;i >= 0; i--){
                    if(p.son[i] != null){
                        for(int j = 0;j < p.son[i].times; j++){
                            list.add(p.son[i].key);
                        }
                        dfs( p.son[i], list, falg);
                    }
                }
            }else{
                for(int i = 0;i < p.son.length; i++){
                    if(p.son[i] != null){
                        for(int j = 0;j < p.son[i].times; j++){
                            list.add(p.son[i].key);
                        }
                        dfs( p.son[i], list, falg);
                    }
                }
            }

        }
    }

    //深度优先遍历，返回一个集合(深度遍历，可返回完全有序的集合)
    public ArrayList<Integer> dfs(){
        ArrayList<Integer> list = new ArrayList<>(100000);
        boolean falg;
        for(int i = 0;i < 20; i++){
            Node2 p = head[i];
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
    public ArrayList<Integer> bfs(){
        LinkedList<Node2> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>(100000);
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
                    Node2 temp = list.poll();
                    int k = temp.key;
                    if(temp != head[p]){
                        for(int j = 0; j < temp.times; j++){
                            res.add(k);
                        }
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
class Node2{
    int key;
    Node2[] son;
    int times = 1;
    public Node2(){

    }
    public Node2(int x){
        key = x;
    }
    public Node2(int x,int time){
        key = x;
        times = time;
    }
}
