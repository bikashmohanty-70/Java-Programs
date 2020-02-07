package com.bridgelabz.design_pattern.behavioral_design_patterns.mediator_deisgn_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 *
 */
public abstract class User 
{
	protected ChatMediator mediator;
	protected String name;

	public User(ChatMediator med, String name)
	{
		this.mediator=med;
		this.name=name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}