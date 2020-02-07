package com.bridgelabz.design_pattern.behavioral_design_patterns.mediator_deisgn_pattern;

public class ChatClient {

	public static void main(String[] args) 
	{
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Bikash");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Swati");
		User user4 = new UserImpl(mediator, "Sam");
		
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Hi All");
		user2.send("Hey There");
		
	}

}

