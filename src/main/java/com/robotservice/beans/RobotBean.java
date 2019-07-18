package com.robotservice.beans;

import org.springframework.stereotype.Component;

import com.robotservice.constants.LightColor;

@Component
public class RobotBean {
	private Double availableCharging;
	private LightColor headIndicator;
	private LightColor chestIndicator;
	
	public RobotBean() {;
		this.availableCharging =100.0;
		this.headIndicator = LightColor.GREEN;
		this.chestIndicator=LightColor.RED;
	}

	public Double getAvailableCharging() {
		return availableCharging;
	}

	public void setAvailableCharging(Double availableCharging) {
		this.availableCharging = availableCharging;
	}

	public LightColor getHeadIndicator() {
		return headIndicator;
	}

	public void setHeadIndicator(LightColor headIndicator) {
		this.headIndicator = headIndicator;
	}

	public LightColor getChestIndicator() {
		return chestIndicator;
	}

	public void setChestIndicator(LightColor chestIndicator) {
		this.chestIndicator = chestIndicator;
	}



}
