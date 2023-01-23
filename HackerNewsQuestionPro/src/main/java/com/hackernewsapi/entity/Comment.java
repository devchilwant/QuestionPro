package com.hackernewsapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Comment {

	@Column
	private String by;
	@Id
	@Column
	private int id;
	@Column
	private List<Integer> kids;
	@Column
	private int parent;
	@Column
	private String text;
	@Column
	private Long time;
	@Column
	private String type;
	
	public Comment() {
		super();
	}

	public Comment(String by, int id, List<Integer> kids, int parent, String text, Long time, String type) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
