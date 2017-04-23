package com.gmSearch.action;

import org.springframework.stereotype.Controller;
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
}
