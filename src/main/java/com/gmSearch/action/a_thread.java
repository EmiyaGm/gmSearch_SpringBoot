package com.gmSearch.action;

import com.gmSearch.entity.e_thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gmSearch.service.is_thread;

import java.util.List;

/**
 * Created by gm on 2017/4/21.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("thread")
public class a_thread {

    @Autowired
    private is_thread isThread;

    @GetMapping(value = "/getAll",produces = "application/json;charset=UTF-8")
    public List<e_thread> getAll(){
        return isThread.getAll();
    }

}
