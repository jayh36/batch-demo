package com.example.batch.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class AopBatchResult {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    private Map<String, Object> inputMap = new HashMap<>();

    @Before("execution(* com.example.batch.service..doBatch(..))")
    public void beforeDoBatch(){
        inputMap.put("STRT_DTTM", format.format(new Date()));
        //log.info("call beforeDoBatch : " + inputMap.get("STRT_DTTM"));
    }

    @After("execution(* com.example.batch.service..doBatch(..))")
    public void afterDoBatch(JoinPoint  joinpoint){
        CommonBatch batch = (CommonBatch)joinpoint.getTarget();
        log.info("[ " + batch.getBatchId() + " ] SUCC_CNT : " + batch.getSuccessCount());
        log.info("[ " + batch.getBatchId() + " ] FAIL_CNT : " + batch.getFailCount());

        try{
            inputMap.put("BATCH_ID", batch.getBatchId());
            inputMap.put("END_DTTM",format.format(new Date()));
            inputMap.put("SUCC_CNT", batch.getSuccessCount());
            inputMap.put("FAIL_CNT", batch.getFailCount());
            log.info("########## Insert Batch Log");
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
