package com.robotservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BarCodeScannerApi {

	@GetMapping("/barCodeScanner/{barCode}")
	public ResponseEntity<Double> getBarCodePrice(@PathVariable("barCode") String barCode);
	
}
