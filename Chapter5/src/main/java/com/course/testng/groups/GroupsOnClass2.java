package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    /*
   * 类分组 通过xml文件运行类分组,
   * 通过<groups>
           <run>
               <include name ="stu"/>
           </run>
       </groups>可以控制访问的组，这里只运行组名为stu的类
   * */
    public void stu1(){
        System.out.println("GroupsOnClass2中的stu1111运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass2中的stu2222运行");
    }
}
