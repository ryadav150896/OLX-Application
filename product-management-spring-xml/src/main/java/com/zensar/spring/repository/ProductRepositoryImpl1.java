package com.zensar.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	//private JdbcTemplate template;
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
	public ProductRepositoryImpl1() {

	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int insertProduct(Product product) {
		//createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		namedParameterJdbcTemplate.update(sql, getSqlParamsByModel(product));
		return 1;
	}

	//public void createTable() {
	//	namedParameterJdbcTemplate.execute("create table product(productId int ,productName varchar(50),productCost int)",getSqlParamsByModel(null));
	//}

	//public JdbcTemplate getTemplate() {
	//	return template;
	//}

	//public void setTemplate(JdbcTemplate template) {
	//	this.template = template;
	//}

	public int updateProduct(Product product) {
		//// TODO Auto-generated method stub
		//return 0;
		
		String sql ="update product set  productName=?, productCost=? where productId=?";
		int updatedRow=namedParameterJdbcTemplate.update(sql, getSqlParamsByModel(product));
		
		return updatedRow;
	}

	public int deleteProduct(int productId) {
		String sql ="Delete from product where productId=?,productName=?";
		int deletedRow=namedParameterJdbcTemplate.update(sql, getSqlParamsByModel(new Product(productId)));;
		return deletedRow;
	}
	public List<Product> getAllProduct(){
		String sql= "select * from product";
		
		List<Product> list=namedParameterJdbcTemplate.query(sql, getSqlParamsByModel(null), new UserMapper() );
		return list;
		
	}
	
	private SqlParameterSource getSqlParamsByModel(Product product) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (product != null) {
			parameterSource.addValue("productId", product.getProductId());
			parameterSource.addValue("productName", product.getProductName());
			parameterSource.addValue("productCost", product.getProductCost());
			
		}
		return parameterSource;
	}
private static final class UserMapper implements RowMapper {

		public Product mapRow(ResultSet  rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setProductCost(rs.getInt("productCost"));
			
			return product;
		}
	

}
public Product findProduct(int productId) {
	String query = "SELECT * FROM product WHERE productId = :productId";
	return (Product)namedParameterJdbcTemplate.queryForObject(query, getSqlParamsByModel(new Product(productId)), new UserMapper());
}
}