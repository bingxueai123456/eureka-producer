package com.ice.controller;

import com.ice.web.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: eclair
 * @Description:
 * @Date: 2019/7/25
 */
@RestController
@Slf4j
public class ProducerController {
	@GetMapping(value = "/api/json/test/get/no/args")
	public String testGet() throws UnknownHostException {
		log.info("test get no args!");
		return ApiResult.succStr("hello, you get all!");
	}

	@PostMapping(value = "/api/json/test/post/no/args")
	public String testPost() throws UnknownHostException {
		log.info("test post no args!");
		return ApiResult.succStr("hello,you call put no args success!");
	}


	@GetMapping(value = "/api/json/test/get/args")
	public String testGetParam(@RequestParam("key") String key) throws UnknownHostException {
		log.info("test get args!");
		return ApiResult.succStr("hello, you get all!" + key );
	}

	@PostMapping(value = "/api/json/test/post/args")
	public String testPostParam(@RequestParam("key") String key) throws UnknownHostException {
		log.info("test post args!");
		return ApiResult.succStr("hello,you call put " + key );
	}

	@PostMapping(value = "/api/json/test/post/args/json", consumes = "application/json")
	public String testPostJson(@RequestBody Apple apple) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		log.info("test post json!");
		return ApiResult.succStr("hello,you call put " + apple + " args success!" + addr.getHostAddress());
	}



}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Apple {
	private String name;
	private Integer age;
}
