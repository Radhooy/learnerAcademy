package com.learnerAcademy.learnerAcademy.Controller;

import com.learnerAcademy.learnerAcademy.Model.teacher;
import com.learnerAcademy.learnerAcademy.Service.impl.classesServiceImpl;
import com.learnerAcademy.learnerAcademy.Service.impl.subjectServiceImpl;
import com.learnerAcademy.learnerAcademy.Service.impl.teacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class teacherController {

    @Autowired
    private teacherServiceImpl teacherService;
    @Autowired
    private classesServiceImpl classesService;
    @Autowired
    private subjectServiceImpl subjectService;

    @GetMapping("/teacher")
    public String teacher(Model model){
        model.addAttribute("teachers" , teacherService.listAll());
        model.addAttribute("class" , classesService.listAll());
        return "teacher";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model){
        model.addAttribute("class" , classesService.listAll());
        model.addAttribute("subjects",subjectService.listAll());
        model.addAttribute("teacher" , new teacher());
        return "addTeacher";
    }


    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute("teacher") teacher teacher
            , @RequestParam(value = "classId" , required = false) int class_id[]
            ,@RequestParam(value = "subjectId" , required = false) int subjectId[]){

        if(class_id != null) {
            System.out.println(class_id[0]);
            for (int id : class_id)
                teacher.addClass(classesService.findById(id));
        }
        if(subjectId != null) {
            for (int id : subjectId)
                teacher.addSubject(subjectService.findById(id));
        }

        if(teacher != null)
            teacherService.create(teacher);

        return "redirect:/teacher";
    }


    @GetMapping("/teacher/delete")
    public String deleteTeacher(@RequestParam("teacherId") int teacherId){
        teacherService.deleteById(teacherId);
        return "redirect:/teacher";
    }



}
