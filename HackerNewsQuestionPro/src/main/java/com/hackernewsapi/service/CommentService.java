package com.hackernewsapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackernewsapi.entity.Comment;
import com.hackernewsapi.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		commentRepository.findAll().forEach(comment -> comments.add(comment));
		return comments;
	}

	public void saveComment(Comment comment){
		commentRepository.save(comment);
	}
}
