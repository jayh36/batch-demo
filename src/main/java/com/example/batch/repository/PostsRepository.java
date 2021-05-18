package com.example.batch.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface PostsRepository {
    void updatePostsModifiedDate(Map map);
    HashMap getTest();
    HashMap getAllPosts();
}
