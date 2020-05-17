
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Salary;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class SalaryServiceImpl implements ISalaryService {
	

	
	public static final Logger log = Logger.getLogger(SalaryServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		
		createSalaryTable();
	}

	private PreparedStatement preparedStatement;

	public static void createSalaryTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
		
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	@Override
	public void addSalary(Salary salary) {

		String employeeID = CommonUtil.generateIDs(getEmployeeByIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SALARY));
			connection.setAutoCommit(false);
			
			
			salary.setEmployeeID(employeeID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, salary.getEmployeeID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, salary.getFistName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, salary.getLastName());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, salary.getWorkDate());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, salary.getBasicSalary());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, salary.getOtHours());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, salary.getOtRate());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_EIGHT, salary.getTotalEpf());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_NING, salary.getTotalSalry());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TEN, salary.getETF());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ELEVEN, salary.getEPF());
			
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	
	@Override
	public Salary getEmployeeByID(String employeeID) {

		return actionOnSalary(employeeID).get(0);
	}
	
	
	@Override
	public ArrayList<Salary> getSalarys() {
		
		return actionOnSalary(null);
	}


	@Override
	public void removeSalary(String employeeID) {

		
		if (employeeID != null && !employeeID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SALARY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, employeeID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	
	private ArrayList<Salary> actionOnSalary(String employeeID) {

		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (employeeID != null && !employeeID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SALARY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, employeeID);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SALARY));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Salary salary = new Salary();
				salary.setEmployeeID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				salary.setFistName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				salary.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				salary.setWorkDate(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				salary.setBasicSalary(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				salary.setOtHours(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
				salary.setOtRate(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				salary.setTotalEpf(resultSet.getInt(CommonConstants.COLUMN_INDEX_EIGHT));
				salary.setTotalSalry(resultSet.getFloat(CommonConstants.COLUMN_INDEX_NING));
				salary.setETF(resultSet.getInt(CommonConstants.COLUMN_INDEX_TEN));
				salary.setEPF(resultSet.getInt(CommonConstants.COLUMN_INDEX_ELEVEN));
				salaryList.add(salary);
				System.out.println("From DB"+salary.getLastName());
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
		
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return salaryList;
	}

	
	@Override
	public Salary updateSalary(String employeeID, Salary salary) {

		
		if (employeeID != null && !employeeID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SALARY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, salary.getFistName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, salary.getLastName());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, salary.getWorkDate());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, salary.getBasicSalary());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, salary.getOtHours());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, salary.getOtRate());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, salary.getTotalEpf());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, salary.getTotalSalry());
				preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_NING, salary.getETF());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TEN, salary.getEPF());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, salary.getEmployeeID());
				
				
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		return getEmployeeByID(employeeID);
	}
	
	
	private ArrayList<String> getEmployeeByIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SALARY_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
