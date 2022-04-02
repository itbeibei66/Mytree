package MyTree;

@SuppressWarnings("all")
class Heap0{
    int[] a;
    int capacity;
    int count;
    public Heap0(int capacity){
        this.capacity=capacity;
        a=new int[capacity];
        count=0;
    }
    public void add(int value){
        if(count==capacity){
            return;
        }
        a[count++]=value;
        int temp=count-1;
        while (true){
            if(temp==0){
                break;
            }
            int pos=a[(temp-1)>>1];
            if(pos<value){
                a[(temp-1)>>1]=value;
                a[temp]=pos;
            }else{
                break;
            }
            temp=(temp-1)>>1;
        }
    }
    public int take() throws Exception {
        if(count==0){
            throw new Exception("没有元素了");
        }
        count--;
        int res=a[0];
        a[0]=a[count];
        int temp=a[0];
        a[count]=0;
        int k=0;
        for(int i=2*k+1;i<count;i=2*i+1){
            if(i+1<count&&a[i]<a[i+1]){
                i++;
            }
            if(temp<a[i]){
                a[k]=a[i];
                k=i;
            }else{
                break;
            }
        }
        a[k]=temp;
        return res;
    }
    public void show(){
        for(int i=0;i<count;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
}