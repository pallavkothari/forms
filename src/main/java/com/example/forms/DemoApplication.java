package com.example.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

	@GetMapping("/")
	String home() {
		return "index";
	}

	@PostMapping("/caps")
    String caps(@RequestParam Map<String, String> requestParams, Map<String, Object> model, @RequestParam("file") MultipartFile file)  {
        model.put("output", requestParams.get("toCapitalize").toUpperCase() + " and your file size was " + file.getSize());
        return "out";
    }


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
