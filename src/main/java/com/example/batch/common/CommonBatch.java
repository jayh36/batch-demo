package com.example.batch.common;

public interface CommonBatch {
    void doBatch(String[] args);
    String getBatchId();
    int getSuccessCount();
    int getFailCount();
}
