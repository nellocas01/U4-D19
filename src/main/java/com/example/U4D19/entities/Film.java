package com.example.U4D19.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Film {
	private int id;
	private String name;
	private String gender;
	private String actor;
}
