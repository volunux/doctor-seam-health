package com.seamhealth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seamhealth.entity.Homepage;

@RestController("")
public class HomeController {

	@GetMapping
	public Homepage home() {
		Homepage home = new Homepage("Seam Health", "Seam Health Consult", "1.0");
		return home;
	}
}
