package dev.gabrieljbo.project.adapters.out.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.commons.exception.SystemErrorCode;
import dev.gabrieljbo.project.commons.exception.SystemException;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public CustomerEntity save(CustomerEntity entity) {
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("ID", entity.getId());
			parameters.put("FIRST_NAME", entity.getFirstName());
			parameters.put("LAST_NAME", entity.getLastName());
			parameters.put("EMAIL", entity.getEmail());

			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("CUSTOMER")
					.usingGeneratedKeyColumns("ID");
			Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
			entity.setId(id.intValue());

			return entity;
		} catch (Exception ex) {
			throw new SystemException(ex, SystemErrorCode.SAVE_CUSTOMER_ERROR_CODE);
		}
	}

	@Override
	public List<CustomerEntity> findAll() {
		try {

			RowMapper<CustomerEntity> customerRowMapper = (rs, rowNum) -> {
				CustomerEntity customerEntity = new CustomerEntity();
				customerEntity.setId(rs.getInt("ID"));
				customerEntity.setFirstName(rs.getString("FIRST_NAME"));
				customerEntity.setLastName(rs.getString("LAST_NAME"));
				customerEntity.setEmail(rs.getString("EMAIL"));

				return customerEntity;
			};

			List<CustomerEntity> allCustomersList = jdbcTemplate.query("select * from CUSTOMER", new Object[] {},
					customerRowMapper);

			return allCustomersList;
		} catch (Exception ex) {
			throw new SystemException(ex, SystemErrorCode.FIND_ALL_CUSTOMERS_ERROR_CODE);
		}
	}

}