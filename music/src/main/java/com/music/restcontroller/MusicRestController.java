package com.music.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Page;

@RestController
@RequestMapping("v1/musics")
public class MusicRestController {

	@GetMapping
	public String hello(){
		
		// Create an API instance. The default instance connects to https://api.spotify.com/.
		Api api = Api.DEFAULT_API; 


		final ArtistSearchRequest request = api.searchArtists("fabio de melo").market("BR").limit(10).build();

		try {
		   final Page<Artist> artistSearchResult = request.get();
		   final List<Artist> artists = artistSearchResult.getItems();

		   System.out.println("I've found " + artistSearchResult.getTotal() + " artists!");

		   for (Artist artist : artists) {
		     System.out.println(artist.getName());
		   }

		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		
		
		return "Hello, Music!";
	}
}
