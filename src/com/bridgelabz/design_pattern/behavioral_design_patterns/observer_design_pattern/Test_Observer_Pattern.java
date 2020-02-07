package com.bridgelabz.design_pattern.behavioral_design_patterns.observer_design_pattern;

public class Test_Observer_Pattern 
{

	public static void main(String[] args) 
	{
		//create subject
		MyTopic topic = new MyTopic();
		
		//create observers
		IObserver obj1 = new MyTopicSubscriber("Obj1");
		IObserver obj2 = new MyTopicSubscriber("Obj2");
		IObserver obj3 = new MyTopicSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//topic.postMessage("New Message");
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("New Message");
	}

}
