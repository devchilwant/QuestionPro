package com.hackernews.entity;

import java.util.List;

import com.hackernews.typeenum.ItemType;

public class Comment {

	private String by;
	private int id;
	private List<Integer> kids;
	private int parent;
	private String text;
	private Long time;
	private ItemType type;
	
	public Comment() {
		super();
	}

	public Comment(String by, int id, List<Integer> kids, int parent, String text, Long time, ItemType type) {
		super();
		this.by = by;
		this.id = id;
		this.kids = kids;
		this.parent = parent;
		this.text = text;
		this.time = time;
		this.type = type;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getKids() {
		return kids;
	}

	public void setKids(List<Integer> kids) {
		this.kids = kids;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Comment [by=" + by + ", id=" + id + ", kids=" + kids + ", parent=" + parent + ", text=" + text
				+ ", time=" + time + ", type=" + type + "]";
	}
	
}
