package com.hilo.entity;

import java.io.Serializable;

public class Robot implements Serializable {
	private static final long serialVersionUID = 1L;
	//protected int robotNo;
	protected String robotNo;
	protected String robotName;
	protected String robotType;
	public String getRobotNo() {
		return robotNo;
	}
	public void setRobotNo(String robotNo) {
		this.robotNo = robotNo;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public String getRobotType() {
		return robotType;
	}
	public void setRobotType(String robotType) {
		this.robotType = robotType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((robotName == null) ? 0 : robotName.hashCode());
		result = prime * result + ((robotNo == null) ? 0 : robotNo.hashCode());
		result = prime * result + ((robotType == null) ? 0 : robotType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Robot other = (Robot) obj;
		if (robotName == null) {
			if (other.robotName != null)
				return false;
		} else if (!robotName.equals(other.robotName))
			return false;
		if (robotNo == null) {
			if (other.robotNo != null)
				return false;
		} else if (!robotNo.equals(other.robotNo))
			return false;
		if (robotType == null) {
			if (other.robotType != null)
				return false;
		} else if (!robotType.equals(other.robotType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Robot [robotNo=" + robotNo + ", robotName=" + robotName + ", robotType=" + robotType + "]";
	}

	
}
