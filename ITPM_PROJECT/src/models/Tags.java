//package models;
//
//import java.sql.*;
//
//import java.util.ArrayList;
//
//import dbConnection.DBConnection;
//
//public class Tags {
//	private DBConnection dbConnection;
//	
//	private int id;
//	private String tagName;
//	private String tagCode;
//	private String relatedTag;
//	
//	
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public String getTagName() {
//		return tagName;
//	}
//
//
//	public void setTagName(String tagName) {
//		this.tagName = tagName;
//	}
//
//
//	public String getTagCode() {
//		return tagCode;
//	}
//
//
//	public void setTagCode(String tagCode) {
//		this.tagCode = tagCode;
//	}
//
//
//	public String getRelatedTag() {
//		return relatedTag;
//	}
//
//
//	public void setRelatedTag(String relatedTag) {
//		this.relatedTag = relatedTag;
//	}
//
//
//	public void insertTags(String tagName, String tagCode, String relatedTag) {
//		
//		try {
//			Connection connection = dbConnection.connect();
//			
//			String insertQuery = "insert into tags values ('2','"+tagName+"', '"+tagCode+"', '"+relatedTag+"')";
//					
//			PreparedStatement ps = connection.prepareStatement(insertQuery);
//			if(ps.execute()) {
//				System.out.println("Inserted Successfully");
//			}
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public ArrayList<Tags> listTags(){
//			
//			ArrayList<Tags> tags_list = new ArrayList<Tags>();
//			
//			try {
//				Connection connection = dbConnection.connect();
//				
//				String listTagsQuery = "select * from tags";
//				
//				Statement statement = connection.createStatement();
//				ResultSet rs =  statement.executeQuery(listTagsQuery);
//				while(rs.next()) {
//					Tags tag = new Tags();
//					tag.setId(rs.getInt(1));
//					tag.setTagName(rs.getString(2));
//					tag.setTagCode(rs.getString(3));
//					tag.setRelatedTag(rs.getString(4));
//					tags_list.add(tag);
//				}
//				
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			return tags_list;
//		}
//	
//	
//	public void updateTags(int id , String tagName, String tagCode, String relatedTag) {
//		
//		try {
//			
//			Connection connection = dbConnection.connect();
//			
//			String updateQuery = "update tags set tagName = '"+tagName+"', tagCode = '"+tagCode+"', relatedTag = '"+relatedTag+"' "
//					+ " where id = '"+id+"' ";
//			PreparedStatement ps = connection.prepareStatement(updateQuery);
//			ps.execute();
//			connection.close();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public void deleteTags(int id) {
//		
//		try {
//			Connection connection = dbConnection.connect();
//			String deleteQuery = "delete from tags where id = '"+id+"' ";
//			
//			PreparedStatement ps = connection.prepareStatement(deleteQuery);
//			ps.execute();
//			connection.close();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	
//}
