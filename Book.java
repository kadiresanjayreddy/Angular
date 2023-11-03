package com.example.angular;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String title;
	private int pages;
	private int releaseDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public static Object get() {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
