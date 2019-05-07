package com.tomato;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SQLRepository {

	@Autowired
	private JdbcTemplate template;

	public List<SQLData> selectALL() {
		return template.query("select * from sample", new BeanPropertyRowMapper<>(SQLData.class));
	}

	public void insert(SQLData data) {
		if (data != null) {
			template.update("insert into sample(name,email)values(?,?)", data.getName(), data.getEmail());
		}
	}

	public void delete(int id) {
		template.update("delete from sample where id = ?", id);
	}

	public void deleteALL() {
		template.update("delete from sample", new HashMap<>());
	}
}
