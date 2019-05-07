package com.tomato;

import java.util.Date;

import lombok.Data;

@Data
public class SQLData {

	private int id;
	private String name;
	private String email;
	private Date created;
	private Date modified;
}
