package com.music.service;

import java.io.Serializable;
import java.util.List;

import com.music.model.object.Music;

@FunctionalInterface
public interface MusicServices extends Serializable {

	public List<Music> findByMusicName(String query, String market);
}
