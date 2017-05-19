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
    public JsonResult getKeyword(String title,String content){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getKeyword(title,content));
    }

    @RequestMapping(value = "/getFreword",produces = "application/json;charset=UTF-8")
    public JsonResult getFreword(){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getFreword());
    }

    @RequestMapping(value = "/topicNum",produces = "application/json;charset=UTF-8")
    public JsonResult topicNum(String topic){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.topicNum(topic));
    }

    @RequestMapping(value = "/search",produces = "application/json;charset=UTF-8")
    public JsonResult search(String title){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.search(title));
    }

    @RequestMapping(value = "/getEmotion",produces = "application/json;charset=UTF-8")
    public JsonResult getEmotion(String content){
        return new JsonResult(ResultCode.SUCCESS,"请求成功",isThread.getEmotion(content));
    }

}
