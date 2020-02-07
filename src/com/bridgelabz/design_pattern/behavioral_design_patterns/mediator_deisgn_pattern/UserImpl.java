package com.bridgelabz.design_pattern.behavioral_design_patterns.mediator_deisgn_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 *
 */
public class UserImpl extends User 
{

	public UserImpl(ChatMediator med, String name) 
	{
		super(med, name);
	}

	@Override
	public void send(String msg)
	{
		System.out.println("\nSender - "+this.name+": \nSending Message="+msg+"\n");
		mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg) 
	{
		System.out.println(this.name+": Received Message:"+msg);
	}

}
