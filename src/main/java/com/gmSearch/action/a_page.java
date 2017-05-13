package com.gmSearch.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gm on 2017/4/23.
 */
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("gmSearch")
public class a_page {
    @RequestMapping(value = "/")
    public String  index(){
        return "index";
    }

    @RequestMapping(value = "/all")
    public String all(){
        return "all";
    }

    @RequestMapping(value = "/item")
    public String item(String name, Model model){
        System.out.print(name);
        model.addAttribute("name",name);
        return "item";
    }

    @RequestMapping(value = "/hobbies_item")
    public String hobbies_item(String name , Model model){
        System.out.print(name);
        model.addAttribute("name",name);
        return "hobbies_item";
    }
}
