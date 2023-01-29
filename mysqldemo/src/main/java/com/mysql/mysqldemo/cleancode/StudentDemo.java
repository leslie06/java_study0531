package com.mysql.mysqldemo.cleancode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDemo {
    public static void main(String[] args) {

        List<Student> stuList = new ArrayList<Student>();
        Student st1 = new Student("123","aaa");
        Student st2 = new Student("234","bbb");
        Student st3 = new Student("345","ccc");
        Student st4 = new Student("345","ccc");
        stuList.add(st1);
        stuList.add(st2);
        stuList.add(st3);
        stuList.add(st4);
        //1.提取出list对象中的一个属性
        List<String> stIdList1 = stuList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(stIdList1);


    }
}
