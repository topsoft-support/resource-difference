package top.topsoft.test;

public class MainTest {
    public static void main(String[] args) {

        System.out.println("-----------------0:");
        System.out.println(MainTest.class.getResource(""));
        System.out.println(MainTest.class.getResource("/"));
        System.out.println(MainTest.class.getClassLoader().getResource(""));
        System.out.println(MainTest.class.getClassLoader().getResource("/"));

        System.out.println("-----------------1:");
        System.out.println(MainTest.class.getResource("/a.txt"));
        System.out.println(MainTest.class.getClassLoader().getResource("a.txt"));
        System.out.println("-----------------2:");
        System.out.println(MainTest.class.getResource("/dir/b.txt"));
        System.out.println(MainTest.class.getClassLoader().getResource("dir/b.txt"));


    }
}
