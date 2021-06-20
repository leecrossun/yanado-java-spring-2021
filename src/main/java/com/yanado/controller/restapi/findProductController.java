package com.yanado.controller.restapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanado.dto.ListProduct;
import com.yanado.dto.ProductNaver;

@Controller
@RequestMapping("restapi")
public class findProductController {
	
	@RequestMapping("result")
	public ModelAndView find(@RequestParam String productName) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", "_1BQCAKgGxjKWxr1j6PP");
        headers.set("X-Naver-Client-Secret", "msZjKvt_aj");
		String url = "https://openapi.naver.com/v1/search/shop.json?query=" + productName + "&display=10&start=1&sort=sim";
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		/*String result = template.exchange(url, HttpMethod.GET,
		request,
		String.class
		).getBody();
		System.out.println(result);*/
		
		ResponseEntity<ListProduct> response = template.exchange(url, 
		        HttpMethod.GET, request, new ParameterizedTypeReference<ListProduct>(){});
		List<ProductNaver> list = Arrays.asList(response.getBody().getProductNaver());
		System.out.println("success controller" + list.get(0).getTitle());
		//ObjectMapper mapper = new ObjectMapper();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("restapi/result");
		mav.addObject("result", list);
		return mav;

	}

}
