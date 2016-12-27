package com.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.music.model.object.Music;
import com.music.service.MusicServices;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Track;

@Service
public class MusicServiceImpl implements MusicServices {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885330290744799796L;
	
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MusicServiceImpl.class);

	@Override
	public List<Music> findByMusicName(String query, String market) {

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
			//"Something went wrong!" + e.getMessage()
			LOG.error("error not found music", e);


		}

		return new ArrayList<>();
	}

}
