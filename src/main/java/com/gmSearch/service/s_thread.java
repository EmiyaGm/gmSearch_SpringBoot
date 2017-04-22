package com.gmSearch.service;

import com.gmSearch.dao.id_thread;
import com.gmSearch.entity.e_thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gm on 2017/4/21.
 */
@Service
public class s_thread implements is_thread{

    @Autowired
    private id_thread idThread;

    @Override
    public List<e_thread> getAll() {
        return idThread.getAll();
    }
}
