package com.robotservice.service.impl;

import java.text.DecimalFormat;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotservice.beans.RobotBean;
import com.robotservice.constants.LightColor;
import com.robotservice.constants.Constants;
import com.robotservice.service.RobotService;
@Service
public class RobotServiceImpl implements RobotService {
	@Autowired
	private RobotBean robot;

	@Override
	public void walkingWithWeight(Double distance, Double weight) {
		
		if(isAbleToWalk(distance) && isAbleToCarryWeight(weight)) {		
			Double requiredCharging=distance*100/Constants.MAX_DISTANCE+2*weight;		
			if(isChargingAvailable(requiredCharging)) {
				System.out.println("Robot has walked "+distance+" with weight "+weight);
				System.out.println("Used Charging "+requiredCharging);
				System.out.println("Available Charging "+robot.getAvailableCharging());
				//System.out.println("Chest Indicator color "+robot.getChestIndicator());
			}
		}
	}


	@Override
	public void displayPrice(int barcode) {
		if(barcode>0) {
			System.out.printf("Price:"+Double.parseDouble(new DecimalFormat("7.2").format(Math.random()*100))+"\n");
		}else {
			System.out.println("Scan Failure");
		}
	}

	private boolean isAbleToCarryWeight(Double weight) {
		Predicate<Double> isValid=val->{
			if(val>Constants.MAX_CAPICITY) {	
				System.out.println("Overweight");
				robot.setChestIndicator(LightColor.RED);
				return false;
				}
				return true;
			};
		return isValid.test(weight);
	}


	private boolean isAbleToWalk(Double distance) {
		Predicate<Double> isValid=val->{
			if(val>Constants.MAX_DISTANCE) {
				return false;
				}
				return true;
			};
		return isValid.test(distance);
	}
	
	private boolean isChargingAvailable(Double requiredCharging) {
		Predicate<Double> isValid=val->{
			if(robot.getAvailableCharging()<requiredCharging) {
				System.out.println("Remaining charging is less than required charging, so this task can not be processed.");
				return false;
			}else {
				Double availableCharing=robot.getAvailableCharging()-requiredCharging;
				robot.setAvailableCharging(availableCharing);
				if(availableCharing<Constants.MIN_CHARGING_ALERT) {
					robot.setHeadIndicator(LightColor.RED);
					System.out.println("Low Battery");					
				}
				return true;
			}
		};
		return isValid.test(requiredCharging);
	}
	
}
