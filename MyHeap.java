package MyTree;

import java.util.ArrayList;

@SuppressWarnings("all")
class MyHeap{
    private int times;
    private int size;
    private ArrayList<int[]> list1=new ArrayList<>();
    private ArrayList<int[]> list2=new ArrayList<>();
    public int getTimes(){
        return this.times;
    }
    public int getSize(){
        return this.size;
    }
    public MyHeap(int size){
        int k=10;
        String s=Integer.toString(size);
        int l=s.length();
        int bb=1;
        for(int i=0;i<l;i++){
            bb=bb*10+1;
        }
        for(int i=1;i<=10;i++){
            k++;
            if(i<=l){
                int[] a=new int[k];
                int[] b=new int[k];
                int[] a1=new int[k];
                int[] b1=new int[k];
                list1.add(a);
                list1.add(0,a1);
                list2.add(b);
                list2.add(0,b1);
                k=k*10;
            }else{
                int[] a=new int[bb];
                int[] b=new int[bb];
                int[] a1=new int[bb];
                int[] b1=new int[bb];
                list1.add(a);
                list1.add(0,a1);
                list2.add(b);
                list2.add(0,b1);
            }
        }
    }

    public void add(int x){
        if(x>0){
            add1(x,1);
        }else if(x<0){
            add2(x,1);
        }else{
            size++;
            list2.get(10)[1]++;
        }

    }
    public void add2(int x,int t){
        String s=Integer.toString(Math.abs(x));
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(9-index).length){
                times=times+t;
                return;
            }
            if(list1.get(9-index)[c+k]==0){
                list1.get(9-index)[c+k]=x;
                list2.get(9-index)[c+k]=t;
                size=size+t;
                return;
            }else{
                if(list1.get(9-index)[c+k]==x){
                    list2.get(9-index)[c+k]=list2.get(9-index)[c+k]+t;
                    size=size+t;
                    return;
                }else if(list1.get(9-index)[c+k]>x){
                    int y=list1.get(9-index)[c+k];
                    int ss=list2.get(9-index)[c+k];
                    list1.get(9-index)[c+k]=x;
                    list2.get(9-index)[c+k]=t;
                    size=size+t-ss;
                    add2(y,ss);
                    return;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
    }
    public void add1(int x,int t){
        String s=Integer.toString(x);
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(index+10).length){
                times=times+t;
                return;
            }
            if(list1.get(index+10)[c+k]==0){
                list1.get(index+10)[c+k]=x;
                list2.get(index+10)[c+k]=t;
                size=size+t;
                return;
            }else{
                if(list1.get(index+10)[c+k]==x){
                    list2.get(index+10)[c+k]=list2.get(index+10)[c+k]+t;
                    size=size+t;
                    return;
                }else if(list1.get(index+10)[c+k]>x){
                    int y=list1.get(index+10)[c+k];
                    int ss=list2.get(index+10)[c+k];
                    list1.get(index+10)[c+k]=x;
                    list2.get(index+10)[c+k]=t;
                    size=size+t-ss;
                    add1(y,ss);
                    return;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
    }

    public boolean search(int x){
        if(x>0){
            return search1(x);
        }else if(x<0){
            return search2(x);
        }else{
            return list2.get(10)[1]>0?true:false;
        }
    }
    public boolean search1(int x){
        String s=Integer.toString(x);
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(index+10).length){
                return false;
            }
            if(list1.get(index+10)[c+k]==0){
                return false;
            }else{
                if(list1.get(index+10)[c+k]==x){
                    return true;
                }else if(list1.get(index+10)[c+k]>x){
                    return false;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
        return false;
    }
    public boolean search2(int x){
        String s=Integer.toString(Math.abs(x));
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(9-index).length){
                return false;
            }
            if(list1.get(9-index)[c+k]==0){
                return false;
            }else{
                if(list1.get(9-index)[c+k]==x){
                    return true;
                }else if(list1.get(9-index)[c+k]>x){
                    return false;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
        return false;
    }

    public boolean delete(int x){
        if(x>0){
            return delete1(x);
        }else if(x<0){
            return delete2(x);
        }else{
            if(list2.get(10)[1]>0){
                size--;
                list2.get(10)[1]--;
                return true;
            }else{
                return false;
            }

        }
    }
    public boolean delete1(int x){
        String s=Integer.toString(x);
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(index+10).length){
                return false;
            }
            if(list1.get(index+10)[c+k]==0){
                return false;
            }else{
                if(list1.get(index+10)[c+k]==x){
                    list2.get(index+10)[c+k]--;
                    size--;
                    if(list2.get(index+10)[c+k]==0){
                      up(x,c+k,true);
                    }
                    return true;
                }else if(list1.get(index+10)[c+k]>x){
                    return false;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
        return false;
    }
    public boolean delete2(int x){
        String s=Integer.toString(Math.abs(x));
        int index=s.length()-1;
        int k=1;
        for(int i=0;i<=index;i++){
            int c=s.charAt(i)-48;
            if(c+k>=list1.get(9-index).length){
                return false;
            }
            if(list1.get(9-index)[c+k]==0){
                return false;
            }else{
                if(list1.get(9-index)[c+k]==x){
                    list2.get(9-index)[c+k]--;
                    size--;
                    if(list2.get(9-index)[c+k]==0){
                        up(x,c+k,false);
                    }
                    return true;
                }else if(list1.get(9-index)[c+k]>x){
                    return false;
                }else{
                    k=(c+k)*10+1;
                }
            }
        }
        return false;
    }
    public int pollFirst(){
        int key=0;
        for(int i=0;i<list1.size();i++){
            int k=1;
            if(i<=9){
                for(int j=9;j>=0;j--){
                    if(list1.get(i)[j+k]!=0){
                        key=list1.get(i)[j+k];
                        size--;
                        list2.get(i)[j+k]--;
                        if(list2.get(i)[j+k]==0){
                            up(key,j+k,false);
                        }
                        return key;
                    }
                }
            }else if(i==10&&list2.get(10)[1]>0){
                size--;
                list2.get(10)[1]--;
                return 0;
            }else{
                for(int j=0;j<10;j++){
                    if(list1.get(i)[j+k]!=0){
                        key=list1.get(i)[j+k];
                        size--;
                        list2.get(i)[j+k]--;
                        if(list2.get(i)[j+k]==0){
                            up(key,j+k,true);
                        }
                        return key;
                    }
                }
            }

        }
        return key;
    }
    public int peekFirst(){
        int key=0;
        for(int i=0;i<list1.size();i++){
            int k=1;
            if(i<=9){
                for(int j=9;j>=0;j--){
                    if(list1.get(i)[j+k]!=0){
                        key=list1.get(i)[j+k];
                        return key;
                    }
                }
            }else if(i==10&&list2.get(10)[1]>0){
                return 0;
            }else{
                for(int j=0;j<10;j++){
                    if(list1.get(i)[j+k]!=0){
                        key=list1.get(i)[j+k];
                        return key;
                    }
                }
            }
        }
        return key;
    }
    public void up(int x,int index,boolean f){
        String s=Integer.toString(Math.abs(x));
        int idx=s.length()-1;
        if(f){
            for(int i=1;i<=10;i++){
                if(index*10+i<list1.get(idx+10).length&&list1.get(idx+10)[index*10+i]!=0){
                    list1.get(idx+10)[index]=list1.get(idx+10)[index*10+i];
                    list2.get(idx+10)[index]=list2.get(idx+10)[index*10+i];
                    up(x,index*10+i,f);
                    return;
                }
            }
            list1.get(idx+10)[index]=0;
            list2.get(idx+10)[index]=0;
        }else{
            for(int i=10;i>=1;i--){
                if(index*10+i<list1.get(9-idx).length&&list1.get(9-idx)[index*10+i]!=0){
                    list1.get(9-idx)[index]=list1.get(9-idx)[index*10+i];
                    list2.get(9-idx)[index]=list2.get(9-idx)[index*10+i];
                    up(x,index*10+i,f);
                    return;
                }
            }
            list1.get(9-idx)[index]=0;
            list2.get(9-idx)[index]=0;
        }

    }

    public int pollLast(){
        int key=0;
        for(int i=list1.size()-1;i>=0;i--){
            int k=1;
            if(i>9){
                for(int j=9;j>=0;j--){
                    if(list1.get(i)[j+k]!=0){
                        return down(i,j+k,true, true);
                    }
                }
            }else if(i==9&&list2.get(10)[1]>0){
                size--;
                list2.get(10)[1]--;
                return 0;
            }else{
                for(int j=0;j<10;j++){
                    if(list1.get(i)[j+k]!=0){
                        return down(i,j+k,true, false);
                    }
                }
            }
        }
        return key;
    }
    public int peekLast(){
        int key=0;
        for(int i=list1.size()-1;i>=0;i--){
            int k=1;
            if(i>9){
                for(int j=9;j>=0;j--){
                    if(list1.get(i)[j+k]!=0){
                        return down(i,j+k,false, true);
                    }
                }
            }else if(i==9&&list2.get(10)[1]>0){
                return 0;
            }else{
                for(int j=0;j<10;j++){
                    if(list1.get(i)[j+k]!=0){
                        return down(i,j+k,false, false);
                    }
                }
            }
        }
        return key;
    }
    public int down(int x,int index,boolean f,boolean g){
        int key=0;
        if(g){
            for(int j=9;j>=0;j--){
                if(j+index*10+1<list1.get(x).length&&list1.get(x)[j+index*10+1]!=0){
                    return down(x,j+index*10+1,f,g);
                }
            }
        }else{
            for(int j=0;j<10;j++){
                if(j+index*10+1<list1.get(x).length&&list1.get(x)[j+index*10+1]!=0){
                    return down(x,j+index*10+1,f,g);
                }
            }
        }
        key=list1.get(x)[index];
        if(f){
            size--;
            list2.get(x)[index]--;
            if(list2.get(x)[index]==0){
                list1.get(x)[index]=0;
            }
        }
        return key;
    }

    public ArrayList<Integer> dfs(){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            if(i<=9){
                for(int j=9;j>=0;j--){
                    if(list1.get(i)[j+1]!=0){
                        dfs(list,i,j+1,false);
                    }
                }
            }else if(i==10&&list2.get(i)[1]!=0){
                for(int j=0;j<list2.get(i)[1];j++){
                    list.add(0);
                }
            }else{
                for(int j=0;j<10;j++){
                    if(list1.get(i)[j+1]!=0){
                        dfs(list,i,j+1,true);
                    }
                }
            }

        }
        return list;
    }
    public void dfs(ArrayList<Integer> list,int index1,int index2,boolean f){
        for(int i=0;i<list2.get(index1)[index2];i++){
            list.add(list1.get(index1)[index2]);
        }
        if(f){
            for(int i=0;i<10;i++){
                if(index2*10+1+i<list1.get(index1).length&&list1.get(index1)[index2*10+1+i]!=0){
                    dfs(list,index1,index2*10+1+i,f);
                }
            }
        }else{
            for(int i=9;i>=0;i--){
                if(index2*10+1+i<list1.get(index1).length&&list1.get(index1)[index2*10+1+i]!=0){
                    dfs(list,index1,index2*10+1+i,f);
                }
            }
        }

    }
}

