package com.robotservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.robotservice.service.BarCodeScannerService;

@RestController
public class BarCodeSacnnerApiController implements BarCodeScannerApi{

	@Autowired
	BarCodeScannerService barCodeScannerService;
	
	@Override
	public ResponseEntity<Double> getBarCodePrice(@PathVariable("barCode") String barCode) {
		try {
			return new ResponseEntity<Double>(barCodeScannerService.getBarCodePrice(barCode),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Double>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
