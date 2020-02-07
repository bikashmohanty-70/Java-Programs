package com.bridgelabz.design_pattern.behavioral_design_patterns.mediator_deisgn_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 *
 */

public interface ChatMediator 
{

	public void sendMessage(String msg, User user);

	void addUser(User user);
}
