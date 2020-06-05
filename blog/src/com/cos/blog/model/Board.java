package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	private int id;
	private int userId;
	private String title;
	private String content;
	private int readCount;
	private Timestamp createDate;
	
//	public String getTitle() { // DB 에 넣을때가 아니라 꺼낼 때,
//		return title.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//	}
}
