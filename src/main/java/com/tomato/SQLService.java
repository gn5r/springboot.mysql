package com.tomato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SQLService {

	@Autowired
	private SQLRepository execute;
	
	public List<SQLData> selectALL() {
		return execute.selectALL();
	}
	
	public void insert(SQLData data) {
		execute.insert(data);
	}
	
	public void delete(int id) {
		execute.delete(id);
	}
	
	public void deleteALL() {
		execute.deleteALL();
	}
}
