package sample.web.ui;

public class test{
    
    private String nn = new String("1");
    private String[] mm = {"2","5"};
    
    void test1(String nn,String[] mm){
        nn = new String("3");
        this.nn = "9";
        mm[0] = "4";
        System.out.println("in test(),mm[0]: "+mm[0]);
        mm = new String[]{"8","7"};
        System.out.println("in test(),nn: "+nn);
        System.out.println("this.nn: "+this.nn);
        System.out.println("mm[0]: "+mm[0]);
    }
    
    public static void main(String[] args){
        int [] a = new int[5];
        test s = new test();
        s.test1(s.nn,s.mm);
        System.out.println(s.nn+"  "+s.mm[0]);
    }
}
