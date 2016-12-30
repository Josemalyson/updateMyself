package com.music.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.object.Music;
import com.music.service.MusicServices;

@RestController
@RequestMapping("v1/musics")
public class MusicRestController {

	@Autowired
	private MusicServices musicServices;

	@GetMapping("/search")
	public List<Music> findByMusicName(@RequestParam("name") String name, @RequestParam("market") String market) {
		List<Music> musics;
		musics = musicServices.findByMusicName(name, market);
		return musics;
	}
}
