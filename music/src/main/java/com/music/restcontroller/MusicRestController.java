package com.music.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.object.Music;
import com.music.service.MusicServices;

@RestController
@RequestMapping("v1/musics")
public class MusicRestController {

	@Autowired
	private MusicServices musicServices;

	@GetMapping("/{name}/{market}")
	public List<Music> hello(@PathVariable("name") String name, @PathVariable("market") String market) {

		List<Music> musics = musicServices.findByMusicName(name, market);

		return musics;
	}
}
