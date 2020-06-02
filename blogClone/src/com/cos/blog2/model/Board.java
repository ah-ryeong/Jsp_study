package com.cos.blog2.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
 private int id;
 private int userId;
 private int title;
 private String content;
 private int readcount;
 private Timestamp createData;
}
