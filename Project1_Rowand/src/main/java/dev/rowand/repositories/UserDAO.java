package dev.rowand.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.rowand.models.User;
import dev.rowand.utils.ConnectionUtil;

public class UserDAO {
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
String sql = "select * from users where username = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new User(
						rs.getString("username"),
						rs.getInt("id"),
						rs.getString("pass"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("reim_id"),
						rs.getFloat("reimburse"),
						rs.getString("type")
						
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


public User getUserByReimburseID(int reim_id) {
	// TODO Auto-generated method stub
String sql = "select * from users where reim_id = ?";
	
	try (Connection conn = cu.getConnection()) {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reim_id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return new User(
					rs.getString("username"),
					rs.getInt("id"),
					rs.getString("pass"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("reim_id"),
					rs.getFloat("reimburse"),
					rs.getString("type")
					
					);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

}
