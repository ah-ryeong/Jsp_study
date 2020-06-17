package com.milktea.vollyball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.milktea.vollyball.db.DBConn;
import com.milktea.vollyball.model.Vollyball;
import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

public class VollyballRepository {

		private static final String TAG = "VollyballRepository : ";
		
		private static VollyballRepository instance = new VollyballRepository();
		private VollyballRepository() {}
		
		public static VollyballRepository getinstance() {
			return instance;
		}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		public List<Vollyball> teamList() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT DISTINCT team ");
			sb.append("FROM vollyball ");
			
			final String SQL = sb.toString();
			
			List<Vollyball> teams = new ArrayList<>();
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Vollyball vollyball = Vollyball.builder()
							.team(rs.getString(1))
							.build();
					teams.add(vollyball);
				}
				return teams;	
			} catch (Exception e) {
				System.out.println(TAG + "teamList() : " + e.getMessage());
			} finally {
				DBConn.close(conn, pstmt);
			}
			return null;
		} // end of teamList()
		
		public List<Vollyball> goName(String name) {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT name, team ");
			sb.append("FROM vollyball ");
			sb.append("WHERE team=? ");
			
			final String SQL = sb.toString();
			
			List<Vollyball> names = new ArrayList<>();
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				// 물음표 완성
				pstmt.setString(1, name);
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Vollyball vollyball = Vollyball.builder()
							.name(rs.getString(1))
							.team(rs.getString(2))
							.build();
					names.add(vollyball);
				}
				return names;	
			} catch (Exception e) {
				System.out.println(TAG + "teamList() : " + e.getMessage());
			} finally {
				DBConn.close(conn, pstmt);
			}
			return null;
		} // end of goName()
		
		public List<Vollyball> goDetail(String name, String team) {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id, name, position ");
			sb.append("FROM vollyball ");
			sb.append("WHERE name LIKE ? AND team=? ");
			
			final String SQL = sb.toString();
			
			List<Vollyball> details = new ArrayList<>();
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				// 물음표 완성
				pstmt.setString(1,name);
				pstmt.setString(2, team);
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Vollyball vollyball = Vollyball.builder()
							.id(rs.getInt(1))
							.name(rs.getString(2))
							.position(rs.getString(3))
							.build();
					details.add(vollyball);
				}
				return details;	
			} catch (Exception e) {
				System.out.println(TAG + "goDetail() : " + e.getMessage());
			} finally {
				DBConn.close(conn, pstmt);
			}
			return null;
		}
}
