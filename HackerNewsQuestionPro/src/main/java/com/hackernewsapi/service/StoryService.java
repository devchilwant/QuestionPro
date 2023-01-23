package com.hackernewsapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackernewsapi.entity.Story;
import com.hackernewsapi.repository.StoryRepository;

@Service
public class StoryService {

	@Autowired
	StoryRepository storyRepository;
	
	public List<Story> getAllStories() {
		List<Story> Stories = new ArrayList<Story>();
		storyRepository.findAll().forEach(Story -> Stories.add(Story));
		return Stories;
	}
	
	public void saveAllStories(List<Story> list){
		storyRepository.saveAll(list);
	}
}
