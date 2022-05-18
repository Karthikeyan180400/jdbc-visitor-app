package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dto.VisitorDto;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionObject;
import static com.ty.visitor.util.AppConstants.*;

public class VisitorDao {
	Connection connection = null;

	public int[] saveVisitor(List<VisitorDto> list) {
		connection = ConnectionObject.getConnection();
		String query = "insert into visitor values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for (VisitorDto visitorDto : list) {
				String name = AES.encrypt(visitorDto.getName(), SECRET_KEY);
				String email = AES.encrypt(visitorDto.getEmail(), SECRET_KEY);
				String phone = AES.encrypt("" + visitorDto.getPhone(), SECRET_KEY);

				preparedStatement.setInt(1, visitorDto.getId());
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, phone);
				preparedStatement.setInt(5, visitorDto.getAge());
				preparedStatement.setString(6, visitorDto.getGender());
				preparedStatement.setString(7, visitorDto.getDob());
				preparedStatement.setString(8, visitorDto.getVisitrDateTime());

				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public VisitorDto getVisitorById(int id) {
		String query = "select * from visitor where id=?";

		try {
			connection = ConnectionObject.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = AES.decrypt(resultSet.getString(2), SECRET_KEY);
				String email = AES.decrypt(resultSet.getString(3), SECRET_KEY);
				String phone = AES.decrypt(resultSet.getString(4), SECRET_KEY);

				VisitorDto visitorDto = new VisitorDto();
				visitorDto.setId(resultSet.getInt(1));
				visitorDto.setName(name);
				visitorDto.setEmail(email);
				visitorDto.setPhone(Long.parseLong(phone));
				visitorDto.setAge(resultSet.getInt(5));
				visitorDto.setGender(resultSet.getString(6));
				visitorDto.setDob(resultSet.getString(7));
				visitorDto.setVisitDateTime(resultSet.getString(8));

				return visitorDto;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public List<VisitorDto> getAllVisitorByDate(String visitDateTime) {
		String query = "select * from visitor where visitdatetime=?";

		connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, visitDateTime);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<VisitorDto> list = new ArrayList<VisitorDto>();
			while (resultSet.next()) {
				VisitorDto visitorDto = new VisitorDto();
				String name = AES.decrypt(resultSet.getString(2), SECRET_KEY);
				String email = AES.decrypt(resultSet.getString(3), SECRET_KEY);
				String phone = AES.decrypt(resultSet.getString(4), SECRET_KEY);

				visitorDto.setId(resultSet.getInt(1));
				visitorDto.setName(name);
				visitorDto.setEmail(email);
				visitorDto.setPhone(Long.parseLong(phone));
				visitorDto.setAge(resultSet.getInt(5));
				visitorDto.setGender(resultSet.getString(6));
				visitorDto.setDob(resultSet.getString(7));
				visitorDto.setVisitDateTime(resultSet.getString(8));

				list.add(visitorDto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}
	
	public List<VisitorDto> getAllVisitorByAgeRange(int age){
		String query = "select * from visitor where age <=?";
		
		connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, age);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<VisitorDto> list = new ArrayList<VisitorDto>();
			while(resultSet.next()) {
				VisitorDto visitorDto = new VisitorDto();
				String name = AES.decrypt(resultSet.getString(2), SECRET_KEY);
				String email = AES.decrypt(resultSet.getString(3), SECRET_KEY);
				String phone = AES.decrypt(resultSet.getString(4), SECRET_KEY);
				visitorDto.setId(resultSet.getInt(1));
				visitorDto.setName(name);
				visitorDto.setEmail(email);
				visitorDto.setPhone(Long.parseLong(phone));
				visitorDto.setAge(resultSet.getInt(5));
				visitorDto.setGender(resultSet.getString(6));
				visitorDto.setDob(resultSet.getString(7));
				visitorDto.setVisitDateTime(resultSet.getString(8));
				
				list.add(visitorDto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}

}
