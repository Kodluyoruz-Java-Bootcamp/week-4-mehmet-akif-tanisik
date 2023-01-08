package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.Banner;

@Repository
public class BannerRepository {

	private static List<Banner> banners = new ArrayList<>();

	public void save(Banner banner) {
		banners.add(banner);
	}

	public List<Banner> findAll() {
		return banners;
	}

}
