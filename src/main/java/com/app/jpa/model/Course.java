package com.app.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	public Course(String name) {
		super();
		this.name = name;
	}
}
