package com.bridgelabz.design_pattern.behavioral_design_patterns.observer_design_pattern;



public interface IObserver {
	
	//method to update the observer, used by subject
	public void update();
	
	//attach with subject to observe
	public void setSubject(ISubject sub);
}
