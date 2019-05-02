package jp.gn5r.spring.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	private List<Entity> findAllEntity() {

		RowMapper<Entity> mapper = new BeanPropertyRowMapper<>(Entity.class);
		String sql = "select * from tutorial;";

		List<Entity> result = jdbcTemplate.query(sql, mapper);

		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex() {
		List<Entity> result = findAllEntity();

		String index = "";

		for (Entity e : result) {
			index += "名前:" + e.getName() + "　メール:" + e.getEmail() + "　パス:" + e.getPassword() + "<br>";
		}

		return index;
	}
}
