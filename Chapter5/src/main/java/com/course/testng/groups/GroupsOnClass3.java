package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    /*
   * 类分组 通过xml文件运行类分组,
   * 通过<groups>
           <run>
               <include name ="stu"/>
           </run>
       </groups>可以控制访问的组，这里只运行组名为stu的类
   * */
    public void  teacher1(){
        System.out.println("GroupsOnClass3中的teacher1运行");
    }

    public void  teacher2(){
        System.out.println("GroupsOnClass3中的teacher2运行");
    }
}
