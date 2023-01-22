package com.hackernews.entity;

public class Story {

	private int id;
	private String title;
	private String url;
	private int score;
	private Long time;
	private String by;
	
	public Story() {
		super();
	}

	public Story(int id,String title, String url, int score, Long time, String by) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.score = score;
		this.time = time;
		this.by = by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	@Override
	public String toString() {
		return "Story [id=\" + id + \"title=" + title + ", url=" + url + ", score=" + score + ", time=" + time + ", by=" + by + "]";
	}

}
