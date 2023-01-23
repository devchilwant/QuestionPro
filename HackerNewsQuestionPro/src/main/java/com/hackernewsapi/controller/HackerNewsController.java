package com.hackernewsapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackernewsapi.entity.Comment;
import com.hackernewsapi.entity.Story;
import com.hackernewsapi.service.CommentService;
import com.hackernewsapi.service.StoryService;

@RestController
public class HackerNewsController {

	@Autowired
	CommentService commentService;
	
	@Autowired
	StoryService storyService;
	
	List<Story> pastList = new ArrayList<>();
	
	@GetMapping("/getAllComments")
	private List<Comment> getAllComments() {
		return commentService.getAllComments();
	}
	
	@GetMapping("/getAllStories")
	private List<Story> getAllStories() {
		return storyService.getAllStories();
	}
	
	@GetMapping("/top-stories")
	@Cacheable("topstories")
	public List<Story> getTopStories() {

		List<Story> list = new ArrayList<>();
		
		List<Integer> li = new RestTemplate()
				.getForObject("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty", ArrayList.class);

		for (int i = 0; i < 10; i++) {

			list.add(new RestTemplate().getForObject(
					"https://hacker-news.firebaseio.com/v0/item/" + li.get(i) + ".json?print=pretty", Story.class));
		}
		
		storyService.saveAllStories(list);
		
		return list.stream().sorted((s1, s2) -> s1.getScore() - s2.getScore()).collect(Collectors.toList());
	}

	@CacheEvict(value = "topstories", allEntries = true)
	@Scheduled(fixedRateString = "${caching.spring.CommentListTTL}")
	public void emptyTopStoriesCache() {
		System.out.println("Empty Cache");
	}
	
	@GetMapping("/past-stories")
	public List<Story> getPastStories() {

		return pastList.stream().sorted((s1, s2) -> s1.getScore() - s2.getScore()).collect(Collectors.toList());
	}

	@GetMapping("/comments")
	public Comment getCommentData(@RequestParam int storyId) {

		Comment comm = new RestTemplate().getForObject(
				"https://hacker-news.firebaseio.com/v0/item/"+storyId+".json?print=pretty", Comment.class);

		commentService.saveComment(comm);
		
		return comm;
	}
}
