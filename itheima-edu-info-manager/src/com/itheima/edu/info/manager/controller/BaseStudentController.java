package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class BaseStudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);
    // 开启学生管理系统，并展示学生管理系统
    public void start() {
//        Scanner sc = new Scanner(System.in);
       studentLoop:while (true) {
           System.out.println("--------欢迎来到 <学生> 管理系统--------");
           System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
           String choice = sc.next();
           switch (choice){
               case "1":
//                   System.out.println("添加");
                   addStudent();
                   break;
               case "2":
                   //System.out.println("删除");
                   deletStudentById();
                   break;
               case "3":
//                   System.out.println("修改");
                   updateStudent();
                   break;
               case "4":
//                   System.out.println("查询");
                   findAllStudent();
                   break;
               case "5":
                   System.out.println("感谢您使用学生管理系统，再见");
                   break studentLoop;
               default:
                   System.out.println("您的输入有误，请重新输入");
                   break;
           }
       }
    }

    public void updateStudent() {
        String updateStuId = inputStudentId();
        Student student = inputStudentInfo(updateStuId);
        studentService.updateStudent(updateStuId, student);
        System.out.println("修改成功");
    }

    public void deletStudentById() {
        String delStuId = inputStudentId();
        studentService.delStudentById(delStuId);
        System.out.println("删除成功");


    }

    public void findAllStudent() {
        Student[] stus = studentService.findAllStudent();
        if(stus == null){
            System.out.println("查无信息，请录入后重新查询");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for(int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if(stu != null){
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    public void addStudent() {
//        StudentService studentService = new StudentService();
//        Scanner sc = new Scanner(System.in);
        String id;
        while(true){
            System.out.println("请输入学生id");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if(flag){
                System.out.println("学号已经被占用，请重新输入");
            }else{
                break;
            }
        }
        Student student = inputStudentInfo(id);
        boolean result = studentService.addStudent(student);
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public String inputStudentId(){
        String id;
        while(true){
            System.out.println("请输入学生id");
            id = sc.next();
            boolean exits = studentService.isExists(id);
            if(!exits){
                System.out.println("您输入的id有误，请重新输入");
            }else{
                break;
            }
        }
        return id;
    }

    public Student inputStudentInfo(String id){
        return null;
    }

}
