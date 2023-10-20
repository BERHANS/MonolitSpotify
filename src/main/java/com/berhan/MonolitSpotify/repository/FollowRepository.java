package com.berhan.MonolitSpotify.repository;

import com.berhan.MonolitSpotify.repository.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FollowRepository  extends JpaRepository<Follow,Long> {
}
