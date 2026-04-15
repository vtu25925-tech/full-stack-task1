package edu.Sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {

	@GetMapping("Product")
	public String ProductService() {
		// TODO Auto-generated constructor stub
		return "Product Service Pages can be loaded here";
	}

}
