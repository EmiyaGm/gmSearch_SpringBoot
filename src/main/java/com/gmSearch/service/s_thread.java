package com.gmSearch.service;

import com.gmSearch.dao.id_thread;
import com.gmSearch.entity.e_thread;
import com.gmSearch.tools.HttpRequest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qcloud.Module.Cvm;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;
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
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
    public Object getKeyword(String title,String content) {
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("SecretId", "AKIDeCoU7bM2ymQs9EFnWtIA2vojfcaTRHC8");
        config.put("SecretKey", "8LZKFzP4ov0whR0MWUFn9LK7oMivzueC");
        config.put("RequestMethod", "POST");
        config.put("DefaultRegion", "sh");
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(),
                config);

        TreeMap<String, Object> params = new TreeMap<String, Object>();

        params.put("title", title);
        params.put("content", content);

		/* generateUrl方法生成请求串,可用于调试使用 */
        //System.out.println(module.generateUrl("DescribeInstances", params));
        String result = null;
        try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            result = module.call("TextKeywords", params);
            JSONObject json_result = new JSONObject(result);
            System.out.println(json_result);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }
        return result;
    }

    @Override
    public Object getFreword() {
        //发送 GET 请求
        String s= HttpRequest.sendGet("http://localhost:8983/solr/gmSearch/admin/luke", "_=1494649051302&fl=title&numTerms=50&wt=json");
        return s;
    }

    @Override
    public long topicNum(String topic){
        String URL="http://127.0.0.1:8983/solr/gmSearch";
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
        return results.getNumFound();
    }

    @Override
    public List<e_thread> search(String title) {
        String URL="http://127.0.0.1:8983/solr/gmSearch";
        HttpSolrClient server = new HttpSolrClient(URL);
        //定义查询内容 * 代表查询所有    这个是基于结果集
        SolrQuery query = new SolrQuery(); //定义查询内容
        query.setQuery("title:"+title);
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
        List<e_thread> titleList = new ArrayList<e_thread>();
        for(SolrDocument solrDocument : results){
            e_thread eThread = new e_thread();
            eThread.setId(Long.parseLong(solrDocument.getFieldValue("id").toString()));
            eThread.setAuthor(solrDocument.getFieldValue("author").toString());
            eThread.setTitle(solrDocument.getFieldValue("title").toString());
            eThread.setGood((Boolean) solrDocument.getFieldValue("good"));
            eThread.setReply_num((Integer) solrDocument.getFieldValue("reply_num"));
            titleList.add(eThread);
        }
        return titleList;
    }

    @Override
    public long topicNum(String topic, String college) {
        String URL="http://127.0.0.1:8983/solr/"+college;
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
        return results.getNumFound();
    }

    @Override
    public String getEmotion(String content) {
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("SecretId", "AKIDeCoU7bM2ymQs9EFnWtIA2vojfcaTRHC8");
        config.put("SecretKey", "8LZKFzP4ov0whR0MWUFn9LK7oMivzueC");
        config.put("RequestMethod", "POST");
        config.put("DefaultRegion", "sh");
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(),
                config);

        TreeMap<String, Object> params = new TreeMap<String, Object>();

        params.put("content", content);

		/* generateUrl方法生成请求串,可用于调试使用 */
        //System.out.println(module.generateUrl("DescribeInstances", params));
        String result = null;
        try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            result = module.call("TextSentiment", params);
            JSONObject json_result = new JSONObject(result);
            System.out.println(json_result);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }
        return result;
    }
}
