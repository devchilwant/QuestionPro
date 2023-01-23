package com.hackernewsapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackernewsapi.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
