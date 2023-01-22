package com.hackernews.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackernews.entity.Comment;
import com.hackernews.entity.Story;

@RestController
public class HackerNewsController {
	
	List<Story> list = new ArrayList<>();

	@GetMapping("/v0/maxitem")
	public int getMaxItem() {
		return new RestTemplate().getForObject("https://hacker-news.firebaseio.com/v0/maxitem.json?print=pretty",
				Integer.class);
	}

	@GetMapping("/top-stories")
	public List<Story> getTopStories() {

		 List<Integer> li = new RestTemplate().getForObject("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty",
				ArrayList.class);
		 
		 for(int i =0; i<10 ;i++) {
			 
			list.add(new RestTemplate().getForObject("https://hacker-news.firebaseio.com/v0/item/"+li.get(i) +".json?print=pretty",
					 Story.class));
		 }
		 
		 return list.stream().sorted((s1,s2) -> s1.getScore()-s2.getScore()).collect(Collectors.toList()); 
	}

	
	@GetMapping("/past-stories")
	public List<Story> getPastStories() {

		 return list.stream().sorted((s1,s2) -> s1.getScore()-s2.getScore()).collect(Collectors.toList()); 
	}
	
	@GetMapping("/comments")
	public List<Comment> getCommentData(@RequestParam int storyId) {
		
		//List<Comment> l = new ArrayList<>();
		
		List<Comment> comm = new RestTemplate().getForObject("https://hacker-news.firebaseio.com/v0/item/"+storyId +".json?print=pretty",
				 ArrayList.class);
		
		return comm.stream().filter( a -> a.getType().equals("comment")).collect(Collectors.toList());
	}

}
