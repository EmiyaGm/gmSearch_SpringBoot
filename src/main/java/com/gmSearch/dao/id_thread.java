package com.gmSearch.dao;

import com.gmSearch.entity.e_thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gm on 2017/4/21.
 */
@Transactional
public interface id_thread extends JpaRepository<e_thread, Long> {

    @Query(value = "select * from thread ", nativeQuery = true)
    @Modifying
    public List<e_thread> getAll();

    @Query(value = "select title from thread ", nativeQuery = true)
    @Modifying
    public List<String> getAlltitle();
}
