package com.gmSearch.action;

import com.gmSearch.tools.JsonResult;
import com.gmSearch.tools.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gmSearch.service.is_thread;


/**
 * Created by gm on 2017/4/21.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("thread")
public class a_thread {

    @Autowired
    private is_thread isThread;

    @RequestMapping(value = "/getAll",produces = "application/json;charset=UTF-8")
    public JsonResult getAll(){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getAll());
    }

    @RequestMapping(value = "/getKeyword",produces = "application/json;charset=UTF-8")
    public JsonResult getKeyword(){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getKeyword());
    }

    @RequestMapping(value = "/getFreword",produces = "application/json;charset=UTF-8")
    public JsonResult getFreword(){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getPreword());
    }

    @RequestMapping(value = "/topicNum",produces = "application/json;charset=UTF-8")
    public JsonResult topicNum(String topic){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.topicNum(topic));
    }

}
