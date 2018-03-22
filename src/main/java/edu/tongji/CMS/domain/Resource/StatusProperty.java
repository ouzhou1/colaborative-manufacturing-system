package edu.tongji.CMS.domain.Resource;

public class StatusProperty {
	
	// running,stop,maintain,archived
	private String currentStatus;
	
	private int workingDays;
	
	private String loadStatus;

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public String getLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}
}
