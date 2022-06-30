package dev.rowand.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.rowand.models.Form;
import dev.rowand.models.User;
import dev.rowand.utils.ConnectionUtil;

public class FormDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


	public Form reimburseRequest(Form f) {
		// TODO Auto-generated method stub
		String sql = "insert into forms values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f.getFormDate());
			ps.setString(2, f.getFormTime());
			ps.setString(3, f.getFormLocation());
			ps.setString(4, f.getDescription());
			ps.setFloat(5, f.getReimburse_rate());
			ps.setFloat(7, f.getCost());
			ps.setString(8, f.getGradingFormat());
			ps.setString(9, f.getTypeOfEvent());
			ps.setString(10, f.getJustification());
			ps.setString(11, f.getStatus());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Form(
						rs.getInt("id"),
						rs.getString("formDate"),
						rs.getString("formTime"),
						rs.getString("formLocation"),
						rs.getString("description"),
						rs.getFloat("reimburse_rate"),
						rs.getFloat("cost"),
						rs.getString("gradingFormat"),
						rs.getString("typeOfEvent"),
						rs.getString("justification"),
						rs.getString("status")
						);	
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Form> getAllRequests() {
		// TODO Auto-generated method stub
		List<Form> forms = new ArrayList<>();
		
		String sql = "select * from forms";
		
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			int id = rs.getInt("id");
			String formDate = rs.getString("formDate");
			String formTime = rs.getString("formTime");
			String formLocal = rs.getString("formLocation");
			String descript = rs.getString("description");
			float rate = rs.getFloat("reimburse_rate");
			float cost = rs.getFloat("cost");
			String gradingFormat = rs.getString("gradingFormat");
			String typeOfEvent = rs.getString("typeOfEvent");
			String justification = rs.getString("justification");
			String status = rs.getString("status");
			
			Form f = new Form(id, formDate, formTime, formLocal, descript, rate, cost, gradingFormat, typeOfEvent, justification, status);
			
			forms.add(f);
			}
			return forms;
			
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		
		return null;
	}


	public Form updateStatus(int id, String status) {
		// TODO Auto-generated method stub
		String sql = "update forms set status = ? where id = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Form(
						rs.getInt("id"),
						rs.getString("formDate"),
						rs.getString("formTime"),
						rs.getString("formLocation"),
						rs.getString("description"),
						rs.getFloat("reimburse_rate"),
						rs.getFloat("cost"),
						rs.getString("gradingFormat"),
						rs.getString("typeOfEvent"),
						rs.getString("justification"),
						rs.getString("status")	
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Form GetRequestByID(int id) {
String sql = "select * from forms where id = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Form(
						rs.getInt("id"),
						rs.getString("formDate"),
						rs.getString("formTime"),
						rs.getString("formLocation"),
						rs.getString("description"),
						rs.getFloat("reimburse_rate"),
						rs.getFloat("cost"),
						rs.getString("gradingFormat"),
						rs.getString("typeOfEvent"),
						rs.getString("justification"),
						rs.getString("status")	
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
		
		
	}


