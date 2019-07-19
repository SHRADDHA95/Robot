package com.robotservice.service.impl;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.robotservice.service.BarCodeScannerService;

@Service
public class BarCodeScannerServiceImpl implements BarCodeScannerService{

	@Override
	public Double getBarCodePrice(String barCode) throws Exception {
		if(barCode.length()>=10) {
			return Double.parseDouble(new DecimalFormat("7.2").format(Math.random()*100));
		}else {
			return 0.0;
		}
	}

}
