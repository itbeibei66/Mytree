package MyTree;

@SuppressWarnings("all")
class Heap{
    Student[] a;
    int capacity;
    int count;
    public Heap(int capacity){
        this.capacity=capacity;
        a=new Student[capacity];
        count=0;
    }
    public void add(Student node2){
        int value=node2.age;
        if(count==capacity){
            return;
        }
        a[count++]=node2;
        int temp=count-1;
        while (true){
            if(temp==0){
                break;
            }
            int pos=a[(temp-1)>>1].age;
            Student pose=a[(temp-1)>>1];
            if(pos<value){
                a[(temp-1)>>1]=node2;
                a[temp]=pose;
            }else{
                break;
            }
            temp=(temp-1)>>1;
        }
    }
    public Student take() throws Exception {
        if(count==0){
            throw new Exception("没有元素了");
        }
        count--;
        Student res=a[0];
        Student cur=new Student(a[count].age);
        a[count]=null;
        a[0]=cur;
        int temp=a[0].age;
        int k=0;
        for(int i=2*k+1;i<count;i=2*i+1){
            if(i+1<count&&a[i].age<a[i+1].age){
                i++;
            }
            if(temp<a[i].age){
                a[k]=a[i];
                k=i;
            }else{
                break;
            }
        }
        a[k]=cur;
        return res;
    }
    public void show(){
        for(int i=0;i<count;i++){
            System.out.print(a[i].age);
            System.out.print(" ");
        }
        System.out.println();
    }
}

