package com.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.music.exception.MusicExecption;
import com.music.model.object.Music;
import com.music.service.MusicServices;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Track;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MusicServiceImpl implements MusicServices {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885330290744799796L;

	@Override
	public List<Music> findByMusicName(String query, String market) {

		if (StringUtils.isEmpty(query) || StringUtils.isEmpty(market)) {
			throw new MusicExecption("Values QUERY or MARKET can't nulls");
		}

		Api api = Api.DEFAULT_API;

		final TrackSearchRequest request = api.searchTracks(query).market(market).limit(10).build();

		try {
			final Page<Track> tracksSearchResult = request.get();
			final List<Track> tracks = tracksSearchResult.getItems();

			List<Music> musics = new ArrayList<>();

			if (!tracks.isEmpty()) {
				tracks.forEach(track -> musics.add(new Music(track)));
				return musics;
			}

		} catch (Exception e) {
			log.error("error not found music", e);
		}

		return new ArrayList<>();
	}

}
