package vaccine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import vaccine.domain.Vaccine;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class VaccineDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_vaccination?"
				              + "user=root&password=mysqlroot");
		    String sql = "select * from tb_user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/bookstore?"
				              + "user=root&password=mysqlroot");
			
			
			String sql = "insert into tb_user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_vaccination?"
				              + "user=root&password=mysqlroot");
			
			
			String sql = "select * from vaccine";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Vaccine vac = new Vaccine();
				vac.setVaccinename(resultSet.getString("vaccine_name"));
	    		vac.setDoses(resultSet.getInt("doses"));
	    		vac.setType(resultSet.getString("type"));
	    		list.add(vac);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

		
}
