package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean isExits(String id) {
        Teacher[] teachers = teacherDao.findAllTeacher();
        boolean exists = false;
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] teachers = teacherDao.findAllTeacher();
        boolean flag = false;
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                flag = true;
                break;
            }
        }
        if(flag){
            return teachers;
        }else{
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacherById(String id, Teacher teacher) {
        teacherDao.updateTeacherById(id, teacher);
    }
}
