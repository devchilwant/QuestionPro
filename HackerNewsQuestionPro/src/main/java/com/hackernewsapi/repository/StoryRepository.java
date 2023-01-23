package com.hackernewsapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackernewsapi.entity.Story;

public interface StoryRepository extends CrudRepository<Story, Integer>{

}
