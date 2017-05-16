package com.gmSearch.action;

import com.gmSearch.entity.e_thread;
import com.gmSearch.service.is_thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String all(Model model){
        Map<String, String> college = new HashMap<String, String>();
        college.put("tsinghua","清华大学");
        college.put("pku","北京大学");
        college.put("fudan","复旦大学");
        college.put("hust","华中科技大学");
        college.put("nju","南京大学");
        college.put("scu","四川大学");
        college.put("sjtu","上海交通大学");
        college.put("whu","武汉大学");
        college.put("xmu","厦门大学");
        college.put("zju","浙江大学");
        long emotion = isThread.topicNum("朋友")+
                isThread.topicNum("男朋友")+
                isThread.topicNum("女朋友")+
                isThread.topicNum("分手");
        long sports = isThread.topicNum("足球")+
                isThread.topicNum("篮球")+
                isThread.topicNum("羽毛球")+
                isThread.topicNum("乒乓球")+
                isThread.topicNum("网球")+
                isThread.topicNum("运动")+
                isThread.topicNum("跑");
        long digit = isThread.topicNum("数码")+
                isThread.topicNum("笔记本")+
                isThread.topicNum("电脑")+
                isThread.topicNum("手机")+
                isThread.topicNum("耳机")+
                isThread.topicNum("平板");
        long read = isThread.topicNum("书");
        long game = isThread.topicNum("游戏")+
                isThread.topicNum("lol")+
                isThread.topicNum("LOL")+
                isThread.topicNum("Dota")+
                isThread.topicNum("cf")+
                isThread.topicNum("dnf")+
                isThread.topicNum("王者荣耀");
        long music = isThread.topicNum("音乐")+
                isThread.topicNum("歌");
        long film = isThread.topicNum("电影");
        long build_body = isThread.topicNum("健身");
        long create = isThread.topicNum("创业");
        long fashion = isThread.topicNum("面膜")+
                isThread.topicNum("化妆")+
                isThread.topicNum("明星")+
                isThread.topicNum("衣")+
                isThread.topicNum("鞋")+
                isThread.topicNum("护肤");
        model.addAttribute("colleges",college);
        model.addAttribute("emotion",emotion);
        model.addAttribute("sports",sports);
        model.addAttribute("digit",digit);
        model.addAttribute("read",read);
        model.addAttribute("game",game);
        model.addAttribute("music",music);
        model.addAttribute("film",film);
        model.addAttribute("build_body",build_body);
        model.addAttribute("create",create);
        model.addAttribute("fashion",fashion);
        return "all";
    }

    @RequestMapping(value = "/item")
    public String item(String college, Model model){
        long emotion = isThread.topicNum("朋友",college)+
                isThread.topicNum("男朋友",college)+
                isThread.topicNum("女朋友",college)+
                isThread.topicNum("分手",college);
        long sports = isThread.topicNum("足球",college)+
                isThread.topicNum("篮球",college)+
                isThread.topicNum("羽毛球",college)+
                isThread.topicNum("乒乓球",college)+
                isThread.topicNum("网球",college)+
                isThread.topicNum("运动",college)+
                isThread.topicNum("跑",college);
        long digit = isThread.topicNum("数码",college)+
                isThread.topicNum("笔记本",college)+
                isThread.topicNum("电脑",college)+
                isThread.topicNum("手机",college)+
                isThread.topicNum("耳机",college)+
                isThread.topicNum("平板",college);
        long read = isThread.topicNum("书",college);
        long game = isThread.topicNum("游戏",college)+
                isThread.topicNum("lol",college)+
                isThread.topicNum("LOL",college)+
                isThread.topicNum("Dota",college)+
                isThread.topicNum("cf",college)+
                isThread.topicNum("dnf",college)+
                isThread.topicNum("王者荣耀",college);
        long music = isThread.topicNum("音乐",college)+
                isThread.topicNum("歌",college);
        long film = isThread.topicNum("电影",college);
        long build_body = isThread.topicNum("健身",college);
        long create = isThread.topicNum("创业",college);
        long fashion = isThread.topicNum("面膜",college)+
                isThread.topicNum("化妆",college)+
                isThread.topicNum("明星",college)+
                isThread.topicNum("衣",college)+
                isThread.topicNum("鞋",college)+
                isThread.topicNum("护肤",college);
        switch (college){
            case "tsinghua":college = "清华大学";break;
            case "pku":college = "北京大学";break;
            case "fudan":college = "复旦大学";break;
            case "hust":college = "华中科技大学";break;
            case "nju":college = "南京大学";break;
            case "scu":college = "四川大学";break;
            case "sjtu":college = "上海交通大学";break;
            case "whu":college = "武汉大学";break;
            case "xmu":college = "厦门大学";break;
            case "zju":college = "浙江大学";break;

        }
        model.addAttribute("college",college);
        model.addAttribute("emotion",emotion);
        model.addAttribute("sports",sports);
        model.addAttribute("digit",digit);
        model.addAttribute("read",read);
        model.addAttribute("game",game);
        model.addAttribute("music",music);
        model.addAttribute("film",film);
        model.addAttribute("build_body",build_body);
        model.addAttribute("create",create);
        model.addAttribute("fashion",fashion);
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
