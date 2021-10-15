package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import entity.User;
import util.CustomerRowMapper;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
 
	private NamedParameterJdbcTemplate npjt;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public NamedParameterJdbcTemplate getNpjt() {
		return npjt;
	}

	public void setNpjt(NamedParameterJdbcTemplate npjt) {
		this.npjt = npjt;
	}
	
	public void add(User user){
		String sql = "insert into CUSTOMERS values(?,?,?)";
		jdbcTemplate.update(sql,
				new Object[]{user.getId(),user.getName(),user.getAge()});
		
		/*NamedParameterJdbcTemplate模板使用Map传参*/
		String sql1="insert into CUSTOMERS (id,name,age) values (:id,:name,:age)";
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", 1);
		paramMap.put("age", "20");
		paramMap.put("name", "npjt");
		paramMap.put("sex", "女");
		npjt.update(sql1, paramMap);
		
		/*NamedParameterJdbcTemplate模板使用实体Bean传参*/
		SqlParameterSource paramSource=new BeanPropertySqlParameterSource(user);
		npjt.update(sql1, paramSource);
	}

	public String findNameById(int id) {
		String sql = "SELECT NAME FROM CUSTOMERS WHERE id = ?";
		String name = (String) jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		return name;
	}

	public int findNumbers() {
		String sql = "SELECT COUNT(*) FROM CUSTOMERS";
		int total = jdbcTemplate.queryForObject(sql,Integer.class);
		return total;
	}

	public List<User> findAll() {
		String sql = "SELECT * FROM CUSTOMERS";
		//List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
		List<User> customers = jdbcTemplate.query(sql, new CustomerRowMapper());
		return customers;
	}


	public User findById(int id) {
		String sql = "SELECT * FROM CUSTOMERS WHERE id = ?";
		User customer = (User) jdbcTemplate.queryForObject(sql,
				new Object[] { id },new CustomerRowMapper());
		return customer;
	}
	
	public Map<String,Object> findMapById(int id){
		String sql = "SELECT * FROM CUSTOMERS WHERE id = ?";
		return jdbcTemplate.queryForMap(sql,new Object[]{id});
	}
	
	public List<Map<String,Object>> findAllMap(){
		String sql = "SELECT * FROM CUSTOMERS";
		return jdbcTemplate.queryForList(sql);
	}
}
