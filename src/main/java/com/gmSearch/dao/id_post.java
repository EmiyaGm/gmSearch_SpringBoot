package com.gmSearch.dao;

import com.gmSearch.entity.e_post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gm on 2017/4/30.
 */
@Transactional
public interface id_post extends JpaRepository<e_post, Long> {

    @Query(value = "select * from post ", nativeQuery = true)
    @Modifying
    public List<e_post> getAll();

}
