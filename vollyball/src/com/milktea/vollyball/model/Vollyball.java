package com.milktea.vollyball.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vollyball {
	
	private int id;
	private String team;
	private String name;
	private String position;
}
