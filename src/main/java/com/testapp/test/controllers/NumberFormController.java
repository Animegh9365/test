package com.testapp.test.controllers;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.testapp.test.model.NumberForm;
import com.testapp.test.service.NumberSortingService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NumberFormController {

    public final NumberSortingService numberSortingService;

    public NumberFormController(NumberSortingService numberSortingService){
        this.numberSortingService = numberSortingService;
    }
    
    @GetMapping("/")
    public String showForm(Model model) {
        
        model.addAttribute("numberForm", new NumberForm());
        return "form";

    }

    @PostMapping("/sort")
    public String sortNumbers(@ModelAttribute NumberForm numberForm, Model model) {
        
        List<Integer> numbers = numberForm.getNumbers();
        numberSortingService.bubbleSort(numbers);
        //add the sorted numbers to the model attribute
        model.addAttribute("numbers", numbers);
        return "result";
    }
    
    
}
