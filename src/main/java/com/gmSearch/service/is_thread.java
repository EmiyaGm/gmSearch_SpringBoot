package com.gmSearch.service;

import com.gmSearch.entity.e_thread;

import java.util.List;

/**
 * Created by gm on 2017/4/21.
 */
public interface is_thread {

    public List<e_thread> getAll();

    public Object getKeyword(String title,String content);

    public Object getFreword();

    public long topicNum(String topic);

    public List<e_thread> search(String title);

    public long topicNum(String topic,String college);

    public String getEmotion(String content);
}
