package com.gmSearch.action;

import com.gmSearch.entity.e_thread;
import com.gmSearch.service.is_thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gm on 2017/4/23.
 */
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("gmSearch")
public class a_page {

    @Autowired
    private is_thread isThread;

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
        model.addAttribute("name",name);
        return "item";
    }

    @RequestMapping(value = "/hobbies_item")
    public String hobbies_item(String name , Model model){
        model.addAttribute("name",name);
        return "hobbies_item";
    }

    @RequestMapping(value = "/search")
    public String search(){
        return "search";
    }

    @RequestMapping(value = "/search_content")
    public String search_content(String title, Model model){
        List<e_thread> results = isThread.search(title);
        model.addAttribute("results",results);
        return "search_content";
    }
}
