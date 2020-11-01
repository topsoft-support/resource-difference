# resource-difference
I found the result of method `getResource` run with java8 and java11 is not the same.

the maven project `t01` run with `java8` and the maven project `t02` run with `java11`

**The resource struct**

> ```
> resources
> 	- dir
> 		b.txt
> 	a.txt
> ```

## t01(jdk8)

code

```java
System.out.println("-----------------0:");
System.out.println(MainTest.class.getResource(""));
System.out.println(MainTest.class.getResource("/"));
System.out.println(MainTest.class.getClassLoader().getResource(""));
System.out.println(MainTest.class.getClassLoader().getResource("/"));//should be null

System.out.println("-----------------1:");
System.out.println(MainTest.class.getResource("/a.txt"));
System.out.println(MainTest.class.getClassLoader().getResource("a.txt"));
System.out.println("-----------------2:");
System.out.println(MainTest.class.getResource("/dir/b.txt"));
System.out.println(MainTest.class.getClassLoader().getResource("dir/b.txt"));
```

result

```sh
-----------------0:
file:/D:/dev/workspace/test/t01/target/classes/top/topsoft/test/
file:/D:/dev/workspace/test/t01/target/classes/
file:/D:/dev/workspace/test/t01/target/classes/
null
-----------------1:
file:/D:/dev/workspace/test/t01/target/classes/a.txt
file:/D:/dev/workspace/test/t01/target/classes/a.txt
-----------------2:
file:/D:/dev/workspace/test/t01/target/classes/dir/b.txt
file:/D:/dev/workspace/test/t01/target/classes/dir/b.txt
```



## t02(jdk11)

code

```java
System.out.println("-----------------0:");
System.out.println(MainTest.class.getResource(""));
System.out.println(MainTest.class.getResource("/"));
System.out.println(MainTest.class.getClassLoader().getResource(""));
System.out.println(MainTest.class.getClassLoader().getResource("/"));//should be null

System.out.println("-----------------1:");
System.out.println(MainTest.class.getResource("/a.txt"));
System.out.println(MainTest.class.getClassLoader().getResource("a.txt"));
System.out.println("-----------------2:");
System.out.println(MainTest.class.getResource("/dir/b.txt"));
System.out.println(MainTest.class.getClassLoader().getResource("dir/b.txt"));
```

result

```sh
-----------------0:
file:/D:/dev/workspace/test/t02/target/classes/top/topsoft/test/
null
null
null
-----------------1:
file:/D:/dev/workspace/test/t02/target/classes/a.txt
file:/D:/dev/workspace/test/t02/target/classes/a.txt
-----------------2:
file:/D:/dev/workspace/test/t02/target/classes/dir/b.txt
null
```



The project `t01` result to be the same as I expected.

But the project `t02` result beyond my expectations.

`MainTest.class.getResource("/")`

`MainTest.class.getClassLoader().getResource("")`

`MainTest.class.getClassLoader().getResource("dir/b.txt")`

Why print null?