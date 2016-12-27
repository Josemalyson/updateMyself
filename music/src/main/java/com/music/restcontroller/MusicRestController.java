package com.music.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Track;

@RestController
@RequestMapping("v1/musics")
public class MusicRestController {

	@GetMapping
	public String hello(){
		
		// Create an API instance. The default instance connects to https://api.spotify.com/.
		Api api = Api.DEFAULT_API; 


//		final ArtistSearchRequest request = api.searchArtists("fabio de melo").market("BR").limit(10).build();
		final TrackSearchRequest  request = api.searchTracks("true love").market("US").limit(10).build();

		try {
		   final Page<Track> tracksSearchResult = request.get();
		   final List<Track> tracks = tracksSearchResult.getItems();

		   System.out.println("I've found " + tracksSearchResult.getTotal() + " artists!");

		   StringBuilder s = new StringBuilder();
		   tracks.forEach(t -> {
			   s.append(t.getName())
			   	.append(" " + t.getHref());
		   });
		   
		   return s.toString();

		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		
		
		return "Hello, Music!";
	}
}
