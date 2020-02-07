package com.bridgelabz.design_pattern.behavioral_design_patterns.mediator_deisgn_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 *
 */
import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator 
{

	private List<User> users;
	
	public ChatMediatorImpl()
	{
		this.users=new ArrayList<>();
	}
	
	@Override
	public void addUser(User user)
	{
		this.users.add(user);
	}
	
	@Override
	public void sendMessage(String msg, User user) 
	{
		for(User u : this.users)
		{
			//sender of the message should not get the message he/she is sending
			if(u != user)
			{
				u.receive(msg);
			}
		}
	}

}
