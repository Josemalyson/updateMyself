package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.object.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
