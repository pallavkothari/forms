package com.example.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

	@GetMapping("/")
	String home() {
		return "index";
	}

	@PostMapping("/caps")
    String caps(@RequestParam Map<String, String> requestParams, Map<String, Object> model)  {
        model.put("output", requestParams.get("toCapitalize").toUpperCase());
        return "out";
    }


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
