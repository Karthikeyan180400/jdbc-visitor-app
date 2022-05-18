package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ty.visitor.dto.UserDto;
import com.ty.visitor.util.ConnectionObject;

public class UserDao {
	Connection connection = null;

	public int[] saveUser(List<UserDto> list) {
		String query = "insert into user values(?,?,?,?,?,?)";
		connection = ConnectionObject.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for (UserDto userDto : list) {
				preparedStatement.setInt(1, userDto.getId());
				preparedStatement.setString(2, userDto.getName());
				preparedStatement.setString(3, userDto.getEmail());
				preparedStatement.setLong(4, userDto.getPhone());
				preparedStatement.setString(5, userDto.getPassword());
				preparedStatement.setString(6, userDto.getRole());

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

	public boolean validateUser(String email, String password) {
		connection = ConnectionObject.getConnection();
		String query = "select * from user where email=? and password=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();

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
		return false;

	}

	public int updateUser(String email, int id) {
		connection = ConnectionObject.getConnection();
		String query = "update user set email=? where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
	
	public int deleteUser(int id) {
		connection = ConnectionObject.getConnection();
		String query = "delete from user where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
