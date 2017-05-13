package com.gmSearch.service;

import com.gmSearch.entity.e_thread;

import java.util.List;

/**
 * Created by gm on 2017/4/21.
 */
public interface is_thread {

    public List<e_thread> getAll();

    public Object getKeyword();

    public Object getFreword();

    public long topicNum(String topic);
}
