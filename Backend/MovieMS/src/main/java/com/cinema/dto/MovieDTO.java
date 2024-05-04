package com.cinema.dto;

import lombok.Data;

@Data
public class MovieDTO {
	private Integer id;
	private String name;
	private String genere;
	private String image;
	private String language;
	private String releaseDate;
	private String Description;
	private Integer rating;
}
