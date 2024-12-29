package com.springboot.restcalls.conroller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
@GetMapping("/pincodedetalis/{pincode}")	
public ResponseEntity<String> getPinCodeDetalis(@PathVariable("pincode") String pincode){
 RestTemplate restTemplate =new RestTemplate();
 ResponseEntity<String>response= restTemplate.getForEntity("https://api.postalpincode.in/pincode/"+pincode ,String.class);
return ResponseEntity.status(HttpStatus.OK).header("Status","Done  ho gaya " ).body(response.getBody());
}
@GetMapping("/thought/{id}")
public ResponseEntity<String> getThought(@PathVariable("id") long id){
	RestTemplate restTemplate =new RestTemplate();
	ResponseEntity<String> response =restTemplate.getForEntity("https://dummyjson.com/quotes/"+id,String.class);
	return response;
}
 @GetMapping("/recepie/{id}")
 public ResponseEntity<String> getReciepie(@PathVariable("id") long id)
 {
	 RestTemplate restTemplate =new RestTemplate();
	 ResponseEntity<String>respose = restTemplate.getForEntity("https://dummyjson.com/recipes/"+id, String.class);
	 return respose;
 }
 @GetMapping("/jokes")
 public ResponseEntity<String>getforfun(){
	 RestTemplate restTemplate =new RestTemplate();
	 ResponseEntity<String> response =restTemplate.getForEntity("https://api.sampleapis.com/jokes/goodJokes",String.class);
	 return response;
 }

 

}
