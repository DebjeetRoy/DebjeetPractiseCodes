package com.debjeet.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjeet.springcloud.model.Coupon;
import com.debjeet.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/coupons")
public class CouponRestController {

	@Autowired
	CouponRepo repo;

	@PostMapping(value = "/coupons")
	public Coupon create(Coupon coupon) {
		return repo.save(coupon);
	}

	@GetMapping(value = "/coupons/{code}")
	public Coupon getCoupon(String code) {
		return repo.findByCode(code);
	}
}
