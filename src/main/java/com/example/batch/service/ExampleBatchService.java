package com.example.batch.service;

import com.example.batch.common.CommonBatch;
import com.example.batch.repository.PostsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ExampleBatchService implements CommonBatch {

    @Autowired
    PostsRepository postsRepository;

    private  final String batchId = "EXAMPLE0001";
    private int successCount = 0 ;
    private  int failCount = 0 ;

    @Override
    public String getBatchId(){ return batchId; }
    @Override
    public int getSuccessCount(){ return successCount; }
    @Override
    public int getFailCount(){ return failCount; }
    @Override
    public void doBatch(String[] args){

        try{
            /* input parameter check*/
            Map<String,String> map = new HashMap<String,String>();
            if( args.length > 1){
                map.put("ID", args[1]);
            }
            /* Batch Logic */
            postsRepository.updatePostsModifiedDate(map);
            successCount++;
        }catch (Exception e){
            log.error("ExampleBatchService::ERROR!!" + e.getMessage());
            failCount++;
        }
    }
}
