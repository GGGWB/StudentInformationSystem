package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();
    public void start() {
        teacherLoop: while(true){
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.next();
            switch (choice){
                case "1":
//                    System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    System.out.println("删除老师");
                    break;
                case "3":
                    System.out.println("修改老师");
                    break;
                case "4":
//                    System.out.println("查看老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统，再见！");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }


    }

    public void findAllTeacher() {
        Teacher[] teachers = teacherService.findAllTeacher();
        if(teachers == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher.getId() + "\t" + teacher.getName() + "\t" + teacher.getAge() + "\t\t" + teacher.getBirthday());
            }
        }
    }

    private void addTeacher() {
        String id;
        while(true){
            System.out.println("请输入老师ID");
            id = sc.next();
            boolean exists = teacherService.isExits(id);
            if(exists){
                System.out.println("id已被占用，请重新输入");
                }
            else{
                break;
            }

        }
        System.out.println("请输入老师名字");
        String name = sc.next();
        System.out.println("请输入老师年龄");
        String age = sc.next();
        System.out.println("请输入老师生日");
        String birthday = sc.next();


        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setBirthday(birthday);

        boolean result = teacherService.addTeacher(teacher);
        if(!result){
            System.out.println("添加失败");
        }else{
            System.out.println("添加成功");
        }

    }
}