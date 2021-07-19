package com.learnerAcademy.learnerAcademy.Controller;

import com.learnerAcademy.learnerAcademy.Model.classes;
import com.learnerAcademy.learnerAcademy.Service.impl.classesServiceImpl;
import com.learnerAcademy.learnerAcademy.Service.impl.studentServiceImpl;
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
public class classesController {

    @Autowired
    private classesServiceImpl classesService;
    @Autowired
    private teacherServiceImpl teacherService;
    @Autowired
    private studentServiceImpl studentService;
    @Autowired
    private subjectServiceImpl subjectService;

    @GetMapping("class")
    public String getClass(Model model){
        model.addAttribute("class" , classesService.listAll());

        return "class";
    }

    @GetMapping("add-class")
    public String addClass(Model model){

        model.addAttribute("class",new classes());
        return "addClass";
    }

    @GetMapping("/class/delete")
    public String deleteClass(@RequestParam("classId") int classId){
        classesService.deleteById(classId);
        return "redirect:/class";
    }


    @GetMapping("class-report")
    public String classReport(Model model){
        model.addAttribute("class",classesService.listAll());
        model.addAttribute("teacher",teacherService.listAll());
        model.addAttribute("student",studentService.listAll());
        model.addAttribute("subject",subjectService.listAll());
        return "classReport";
    }

    @PostMapping("add-class")
    public String addClass(@ModelAttribute("class") classes classes){
        classesService.create(classes);
        return "redirect:/class";
    }

}
