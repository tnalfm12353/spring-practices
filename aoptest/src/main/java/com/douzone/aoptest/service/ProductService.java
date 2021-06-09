package com.douzone.aoptest.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVo;

@Service
public class ProductService {

	public ProductVo find(String name) {
		System.out.println("[ProductService] finding... ");
//		if(1-1 == 0) {
//			throw new RuntimeErrorException(null);
//		}
		ProductVo vo = new ProductVo(name);
		return vo;
	}

}
