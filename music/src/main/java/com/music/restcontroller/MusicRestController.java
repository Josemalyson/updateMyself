package com.music.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/musics")
public class MusicRestController {

	@GetMapping
	public String hello(){
		return "Hello, Music!";
	}
}
