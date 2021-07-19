package com.learnerAcademy.learnerAcademy.Controller;

import com.learnerAcademy.learnerAcademy.Model.subject;
import com.learnerAcademy.learnerAcademy.Service.impl.classesServiceImpl;
import com.learnerAcademy.learnerAcademy.Service.impl.subjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class subjectController {

    @Autowired
    private subjectServiceImpl subjectService;
    @Autowired
    private classesServiceImpl classesService;

    @GetMapping("/subject")
    public String getSubject(Model model){
        model.addAttribute("subjects", subjectService.listAll());

        return "subject";
    }


    @GetMapping("/subject/delete")
    public String deleteSubject(@RequestParam("subjectId") int subjectId){
        subjectService.deleteById(subjectId);
        return "redirect:/subject";
    }

    @GetMapping("/addSubject")
    public String addSubject(Model model){
        model.addAttribute("subject",new subject());
        model.addAttribute("class",classesService.listAll());
        return "addSubject";
    }


    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("teacher") subject subject , @RequestParam(value = "classId" , required = false) int class_id[]){
        if(class_id != null)
            for(int id : class_id)
                subject.addClass(classesService.findById(id));

        subjectService.create(subject);
        return "redirect:/subject";
    }


}
