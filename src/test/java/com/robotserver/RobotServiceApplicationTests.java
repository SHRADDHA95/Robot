package com.robotserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotservice.RobotServiceApplication;
import com.robotservice.service.BarCodeScannerService;
import com.robotservice.service.RobotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotServiceApplication.class)
public class RobotServiceApplicationTests {

	@Autowired
	RobotService robotService;

	@Autowired
	BarCodeScannerService barCodeScannerService;
	
	@Before
	public void setUp() {
	}

	@After
	public void teraDown() {

	}

	@Test
	public void walkingWithWeightTest1() {
		try {
			Double availableCharging = robotService.walkingWithWeight(5.5, 0.0);
			assertNotNull(availableCharging);
			assertEquals(0.0, availableCharging.doubleValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void walkingWithWeightTest2() {
		try {
			Double availableCharging = robotService.walkingWithWeight(2.0, 3.0);
			assertNotNull(availableCharging);
			assertEquals(54.0, availableCharging.doubleValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void walkingWithWeightTest3() {
		try {
			Double availableCharging = robotService.walkingWithWeight(0.0, 12.0);
			assertNotNull(availableCharging);
			assertEquals(0.0, availableCharging.doubleValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void getBarCodePriceTest1() {
		try {
			Double price = barCodeScannerService.getBarCodePrice("invalid");
			assertNotNull(price);
			assertEquals(0.0, price.doubleValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void getBarCodePriceTest2() {
		try {
			Double price = barCodeScannerService.getBarCodePrice("valid-bar-code");
			assertNotNull(price);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	

}
