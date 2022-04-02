package MyTree;

import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
        //Heap heap=new Heap(12500000);
        //Heap0 heap0=new Heap0(12500000);
        //myTree tree=new myTree();
        //myTreePlus ptree=new myTreePlus();
        //erchaTree tree1=new erchaTree();
        //HashSet<Integer> set=new HashSet<>();
        //HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Student> treeSet=new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age==o2.age){
                    return 1;
                }else{
                    return o1.age-o2.age;
                }
            }
        });
        TreeSet<Integer> treeSet1=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num=o1.compareTo(o2);
                return num==0?1:num;
            }
        });
        MyTreeLast<Student> ppt=new MyTreeLast<Student>((s)->(s.age));
        //MyHeap myHeap=new MyHeap(9000000);
        System.out.println(1);
        Thread.sleep(15000);
        Random r=new Random();
        //int[] nums=new int[12500000];
        //System.out.println(2);
        //Thread.sleep(15000);
        Student[] ss=new Student[12500000];
        System.out.println(3);
        Thread.sleep(15000);
        int x=0;
        for(int i=0;i<12500000;i++){
            if(r.nextInt(2)==0){
                x = r.nextInt(12500000);
            }else{
                x = -r.nextInt(12500000);
            }
            //nums[i] = r.nextInt(100000);
            ss[i]=new Student(x);
        }
        System.out.println(4);
        Thread.sleep(15000);
        int myheapadd=0;
        int treesetadd=0;
        int mytreeplusadd=0;
        int heapadd=0;
        int heapdelete=0;
        int myheapsearch=0;
        int treesetsearch=0;
        int mytreeplussearch=0;
        int mytreeplusdelete=0;
        int myheapdelete=0;
        int treesetdelete=0;
        int treesetpoll=0;
        int mytreepluspoll=0;
        int myheappoll=0;
        int mytreelastadd=0;
        int mytreelastsearch=0;
        int mytreelastpoll=0;
        int mytreelastdelete=0;
        int k=1;
        for(int i=0;i<k;i++){


            treesetadd=treesetadd+testAdd(treeSet,ss);
            System.out.println(5);
            Thread.sleep(15000);
            //treesetsearch=treesetsearch+testSearch(treeSet,ss);
            //treesetdelete=treesetdelete+testDelete(treeSet,ss);
            //treesetpoll=treesetpoll+testPoll(treeSet,ss);

            //mytreeplusadd=mytreeplusadd+testAdd(ptree,nums);
            //mytreeplussearch=mytreeplussearch+testSearch(ptree,nums);
            //mytreeplusdelete=mytreeplusdelete+testDelete(ptree,nums);
            //mytreepluspoll=mytreepluspoll+testPollLast(ptree,nums);

            mytreelastadd=mytreelastadd+testAdd(ppt,ss);
            System.out.println(6);
            Thread.sleep(15000);
            //mytreelastsearch=mytreelastsearch+testSearch(ppt,ss);
            //mytreelastdelete=mytreelastdelete+testDelete(ppt,ss);
            //mytreelastpoll=mytreelastpoll+testPollFirst(ppt,ss);

            //myheapadd=myheapadd+testAdd(myHeap,nums);
            //myheapsearch=myheapsearch+testSearch(myHeap,nums);
            //myheapdelete=myheapdelete+testDelete(myHeap,nums);
            //myheappoll=myheappoll+testPollFirst(myHeap,nums);

            //heapadd=heapadd+testAdd(heap0,nums);
            //heapdelete=heapdelete+testPoll(heap0,nums);

            //heapadd=heapadd+testAdd(heap,ss);
            //heapdelete=heapdelete+testPoll(heap,ss);
        }

        //System.out.println(treesetadd/k);
        //System.out.println(treesetsearch/k);
        //System.out.println(treesetdelete/k);
        //System.out.println(treesetpoll/k);
        System.out.println();

        //System.out.println(mytreeplusadd/k);
        //System.out.println(mytreeplussearch/k);
        //System.out.println(mytreeplusdelete/k);
        //System.out.println(mytreepluspoll/k);
        System.out.println();

        //System.out.println(mytreelastadd/k);
        //System.out.println(mytreelastsearch/k);
        //System.out.println(mytreelastdelete/k);
        //System.out.println(mytreelastpoll/k);

        //System.out.println(myheapadd/k);
        //System.out.println(myheapsearch/k);
        //System.out.println(myheapdelete/k);
        //System.out.println(myheappoll/k);
        System.out.println();
        //System.out.println(heapadd/k);
        //System.out.println(heapdelete/k);

        //testAdd(myHeap,nums);
        //System.out.println(myHeap.getTimes());
        //System.out.println(myHeap.getSize());
        //testSearch(myHeap,nums);
        //testDelete(myHeap,nums);
        //testPollLast(myHeap,nums);
        //testPollFirst(myHeap,nums);
        //System.out.println(myHeap.dfs());

        //testAdd(heap0,nums);
        //testPoll(heap0,nums);

        //testAdd(ppt,ss);
        //testSearch(ppt,ss);
        //testDelete(ppt,ss);
        //testPollLast(ppt,ss);
        //System.out.println(ppt.dfs());

        //testAdd(ptree,nums);
        //testSearch(ptree,nums);
        //testDelete(ptree,nums);
        //testPollFirst(ptree,nums);
        //testPollLast(ptree,nums);
        //System.out.println(ptree.bfs());
        //System.out.println(ptree.dfs());

        //testAdd(treeSet,ss);
        //testSearch(treeSet,ss);
        //testDelete(treeSet,ss);
        //testPoll(treeSet,ss);

        //testAdd(treeSet1,nums);
        //testSearch(treeSet1,nums);
        //testDelete(treeSet1,nums);
        //testPoll(treeSet1,nums);

        //testAdd(tree,nums);
        //testSearch(tree,nums);
        //testPollLast(tree,nums);
        //testDelete(tree,nums);
        //testPollFirst(tree,nums);
        //System.out.println(tree.bfs());
        //System.out.println(tree.dfs());

        //testAdd(tree1,nums);
        //testSearch(tree1,nums);

        //testAdd(set,nums);
        //testSearch(set,nums);

        //testAdd(map,nums);
        //testSearch(map,nums);



    }
    public static int testAdd(Heap0 heap0,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            heap0.add(nums[i]);
        }
        long end=System.currentTimeMillis();

        return (int)(end-begin);
    }
    public static int testPoll(Heap0 heap0,int[] nums) throws Exception {
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            heap0.take();
        }
        long end=System.currentTimeMillis();
        return (int)(end-begin);
    }

    public static int testAdd(Heap heap,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
        }
        long end=System.currentTimeMillis();

        return (int)(end-begin);
    }
    public static int testPoll(Heap heap,Student[] nums) throws Exception {
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            heap.take();
        }
        long end=System.currentTimeMillis();
        return (int)(end-begin);
    }

    public static int testAdd(MyHeap myHeap,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            myHeap.add(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("神奇数据结构添加"+nums.length+"个元素的时间是"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(MyHeap myHeap,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            myHeap.search(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("神奇数据结构寻找"+nums.length+"个存在元素的时间是"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testDelete(MyHeap myHeap,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            myHeap.delete(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("神奇数据结构删除"+nums.length+"个元素的时间是"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollFirst(MyHeap myHeap,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            myHeap.pollFirst();
        }
        long end=System.currentTimeMillis();
        //System.out.println("神奇数据结构移除"+nums.length+"个最小元素的时间是"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollLast(MyHeap myHeap,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            myHeap.pollLast();
        }
        long end=System.currentTimeMillis();
        //System.out.println("神奇数据结构移除"+nums.length+"个最大元素的时间是"+(end-begin)+"ms");
        return (int)(end-begin);
    }

    public static int testAdd(MyTreeLast<Student> ppt,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ppt.add(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的对象版树插入"+nums.length+"个数据需要"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(MyTreeLast<Student> ppt,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ppt.search(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的对象版树查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testDelete(MyTreeLast<Student> ppt,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ppt.delete(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的对象版树删除"+nums.length+"个数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollFirst(MyTreeLast<Student> ppt,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ppt.pollFirst();
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的对象版树取出"+nums.length+"个最小数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollLast(MyTreeLast<Student> ppt,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ppt.pollLast();
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的对象版树取出"+nums.length+"个最大数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }

    public static int testDelete(myTreePlus ptree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ptree.delete(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的升级版树删除"+nums.length+"个数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(myTreePlus ptree,int[] nums){


        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ptree.search(nums[i]);
        }
        long end=System.currentTimeMillis();

        //System.out.println("我的升级版树查找"+nums.length+"个无范围随机数据需要："+(end1-begin1)+"ms");
        //System.out.println("我的升级版树查找"+nums.length+"个范围内合理随机数据需要："+(end2-begin2)+"ms");
        //System.out.println("我的升级版树查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testAdd(myTreePlus ptree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ptree.add(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的升级版树插入"+nums.length+"个数据需要"+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollFirst(myTreePlus ptree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ptree.pollFirst();
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的树取出"+nums.length+"个最小数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testPollLast(myTreePlus ptree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            ptree.pollLast();
        }
        long end=System.currentTimeMillis();
        //System.out.println("我的树取出"+nums.length+"个最大数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }

    public static void testAdd(myTree tree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.add(nums[i]);
        }
        long end=System.currentTimeMillis();
        System.out.println("我的树插入"+nums.length+"个数据需要："+(end-begin)+"ms");
    }
    public static void testDelete(myTree tree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.delete(nums[i]);
        }
        long end=System.currentTimeMillis();
        System.out.println("我的树删除"+nums.length+"个数据需要："+(end-begin)+"ms");
    }
    public static void testSearch(myTree tree,int[] nums){
        Random r=new Random();
        long begin1=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.search(Math.abs(r.nextInt(nums.length/100)));
        }
        long end1=System.currentTimeMillis();
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.search(nums[i]);
        }
        long end=System.currentTimeMillis();

        System.out.println("我的树查找"+nums.length+"个随机数据需要："+(end1-begin1)+"ms");
        System.out.println("我的树查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
    }
    public static void testPollFirst(myTree tree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.pollFirst();
        }
        long end=System.currentTimeMillis();
        System.out.println("我的树取出"+nums.length+"个最小数据需要："+(end-begin)+"ms");
    }
    public static void testPollLast(myTree tree,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree.pollLast();
        }
        long end=System.currentTimeMillis();
        System.out.println("我的树取出"+nums.length+"个最大数据需要："+(end-begin)+"ms");
    }

    public static int testDelete(TreeSet<Student> treeSet,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.remove(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方Treeset删除"+nums.length+"个数据需要："+(end7-begin7)+"ms");
        return (int)(end-begin);
    }
    public static int testPoll(TreeSet<Student> treeSet,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.pollFirst();
        }
        long end=System.currentTimeMillis();
        //System.out.println("TreeSet删除"+nums.length+"个最小数据需要："+(end9-begin9)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(TreeSet<Student> treeSet,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.contains(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方Treeset查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testAdd(TreeSet<Student> treeSet,Student[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.add(nums[i]);
        }
        long end=System.currentTimeMillis();

        //System.out.println("官方Treeset插入"+nums.length+"个数据需要："+(end6-begin6)+"ms");
        return (int)(end-begin);
    }

    public static int testDelete(TreeSet<Integer> treeSet,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.remove(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方Treeset删除"+nums.length+"个数据需要："+(end7-begin7)+"ms");
        return (int)(end-begin);
    }
    public static int testPoll(TreeSet<Integer> treeSet,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.pollLast();
        }
        long end=System.currentTimeMillis();
        //System.out.println("TreeSet删除"+nums.length+"个最小数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(TreeSet<Integer> treeSet,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.contains(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方Treeset查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testAdd(TreeSet<Integer> treeSet,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            treeSet.add(nums[i]);
        }
        long end=System.currentTimeMillis();

        //System.out.println("官方Treeset插入"+nums.length+"个数据需要："+(end6-begin6)+"ms");
        return (int)(end-begin);
    }

    public static int testAdd(HashSet<Integer> set,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方set插入"+nums.length+"个数据需要："+(end2-begin2)+"ms");
        return (int)(end-begin);
    }
    public static int testSearch(HashSet<Integer> set,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            set.contains(nums[i]);
        }
        long end=System.currentTimeMillis();
        //System.out.println("官方set查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }

    public static int testSearch(HashMap<Integer,Integer> map,int[] nums){

        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            map.containsKey(nums[i]);
        }
        long end=System.currentTimeMillis();

        //System.out.println("官方哈希表查找"+nums.length+"个存在数据需要："+(end-begin)+"ms");
        return (int)(end-begin);
    }
    public static int testAdd(HashMap<Integer,Integer> map,int[] nums){
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],0);
        }
        long end=System.currentTimeMillis();

        //System.out.println("官方哈希表插入"+nums.length+"个数据需要："+(end4-begin4)+"ms");
        return (int)(end-begin);
    }

    public static void testAdd(erchaTree tree1,int[] nums){
        long begin8=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree1.add(nums[i]);
        }
        long end8=System.currentTimeMillis();

        System.out.println("二叉树插入"+nums.length+"个数据需要："+(end8-begin8)+"ms");
    }
    public static void testSearch(erchaTree tree1,int[] nums){
        Random r=new Random();
        long begin9=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree1.find(Math.abs(r.nextInt(1999999999)));
        }
        long end9=System.currentTimeMillis();
        long begin=System.currentTimeMillis();
        for(int i=0;i<nums.length;i++){
            tree1.find(nums[i]);
        }
        long end=System.currentTimeMillis();
        System.out.println("二叉树查找"+nums.length+"个数据需要："+(end9-begin9)+"ms");
        System.out.println("二叉树查找"+nums.length+"个数据需要："+(end-begin)+"ms");
    }
}
class Student{
    int age;
    public Student(){

    }
    public Student(int a){
        age=a;
    }
}

