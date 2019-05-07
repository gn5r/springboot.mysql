package com.tomato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Contoller {

	@Autowired
	private SQLService service;

	@GetMapping
	public String getIndex(Model model) {
		List<SQLData> list = service.selectALL();
		model.addAttribute("list", list);
		return "sample/index";
	}
	
	@PostMapping("/insert")
	public String postIndex(@ModelAttribute("list") SQLData data,Model model) {
		SQLData insertData = data;
		service.insert(insertData);
		return "redirect:sample/index";
	}
	
	@GetMapping("/delete")
	public String deleteOne(@ModelAttribute("id")int id,Model model) {
		service.delete(id);
		return "redirect:sample/index";
	}
}
