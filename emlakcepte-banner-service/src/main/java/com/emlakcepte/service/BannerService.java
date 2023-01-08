package com.emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emlakcepte.model.Banner;
import com.emlakcepte.repository.BannerRepository;

@Service
public class BannerService {

	@Autowired
	private BannerRepository bannerRepository;

	public void create(Banner banner) {
		bannerRepository.save(banner);
		System.out.println("BannerService :: banner kaydedildi");
	}

	public List<Banner> getAll() {
		return bannerRepository.findAll();
	}

}
