package com.melodyrent.repository;
import com.melodyrent.entity.MusicTrack;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MusicTrackRepository extends JpaRepository<MusicTrack, Long> { }
