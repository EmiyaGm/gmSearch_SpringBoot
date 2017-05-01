package com.gmSearch.service;

import com.gmSearch.dao.id_thread;
import com.gmSearch.entity.e_thread;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    @Override
    public Object getKeyword() {
        HttpResponse<JsonNode> clusterPushResponse = null;

        try {
            clusterPushResponse = Unirest
                    .post("http://api.bosonnlp.com/keywords/analysis")
                    .header("Accept", "application/json")
                    .header("X-Token", "HCQrT8q0.14492.O4XXuOZ8HWQw")
                    .body(new JSONArray(idThread.getAlltitle()).toString())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return clusterPushResponse;
    }

    @Override
    public Object getPreword() {
        return null;
    }

    @Override
    public long topicNum(String topic){
        String URL="http://127.0.0.1/solr/gmSearch";
        HttpSolrClient server = new HttpSolrClient(URL);
        //定义查询内容 * 代表查询所有    这个是基于结果集
        SolrQuery query = new SolrQuery(topic); //定义查询内容
        query.setStart(0);//起始页
        query.setRows(20000);//每页显示数量
        QueryResponse rsp = null;
        try {
            rsp = server.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SolrDocumentList results = rsp.getResults();
        System.out.println(results.getNumFound());//查询总条数
        for(SolrDocument doc:results){
            System.out.println(doc);
        }
        return results.getNumFound();
    }
}
