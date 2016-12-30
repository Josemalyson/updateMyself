package com.music.model.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wrapper.spotify.models.Track;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "TB_MUSIC")
@EqualsAndHashCode(exclude = { "track" })
@ToString
public class Music implements Serializable {

	private static final java.lang.String EMPTY_STRING = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 2772217399091537285L;

	@Column(name = "ID_MUSIC")
	@Id
	private String id;

	@javax.persistence.Transient
	private Track track;

	public Music() {
		super();
	}

	public Music(Track track) {
		this.track = track;

	}

	public String getName() {

		if (this.track.getName() != null) {
			return this.track.getName();
		}

		return EMPTY_STRING;

	}

	public String getId() {
		if (this.track.getId() != null) {
			this.id = this.track.getId();
			return this.id;
		}

		return EMPTY_STRING;
	}

	public String getILinkMusic() {
		if (this.track.getPreviewUrl() != null) {
			return this.track.getPreviewUrl();
		}
		return EMPTY_STRING;
	}

	public String getArtists() {
		if (this.track.getArtists() != null) {

			StringBuilder artistsBuilder = new StringBuilder();

			this.track.getArtists().forEach(artists -> artistsBuilder.append(artists.getName()));

			return artistsBuilder.toString();
		}

		return EMPTY_STRING;
	}

}
