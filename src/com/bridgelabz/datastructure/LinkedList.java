package com.bridgelabz.datastructure;

import com.bridgelabz.utility.InputUtility;

class Node
{
	private Node next;
	private int data;

	public Node()
	{
		data= 0;
		next = null;
	}
	public Node(int d, Node node)
	{
		data = d;
		next = node;
	}
	public void setNext(Node n) 
	{
		this.next = n;
	}

	public Node getNext() 
	{
		return next;
	}

	public void setData(int da) 
	{
		this.data = da;
	}

	public int getData() {
		return data;
	}

}

class LinkedListFunctions
{
	private int size;
	private Node start;

	public LinkedListFunctions()
	{
		size = 0;
		start = null;
	}

	public boolean isEmpty()
	{
		if(start == null)
			return (true);
		else
			return (false);
	}

	public int getListSize()
	{
		
		return size;
	}

	public void display()
	{
		Node temp;
		if(isEmpty())
			System.out.println("List is EMpty");
		else
		{
			temp = start;
			for (int i = 1; i <= size; i++) 
			{
				System.out.print(temp.getData()+" ");
				temp = temp.getNext();

			}
			System.out.println();
		}
	}

	public void insertAtFirst(int value)
	{
		Node n = new Node();
		n.setData(value);
		n.setNext(start);
		start = n;
		size++;
	}

	public void insertAtLast(int value)
	{
		Node n, temp;
		n = new Node();
		n.setData(value);
		temp = start;
		if(temp == null)
			start = n;
		else 
		{
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
		size++;

	}

	public void insertAtPosition(int value, int position)
	{
		if(position == 1)
			insertAtFirst(value);
		else if(position == size+1)
			insertAtLast(value);
		else if(position > 1 && position <= size)
		{
			Node n, t;
			n = new Node(value, null);
			t = start;
			for(int i = 1; i < position-1; i++)
				t = t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
		else
			System.out.println("Invalid position "+position);

	}

	public void deleteFirst()
	{
		if(start == null)
			System.out.println("List is Empty. How can I Delete... :P");
		else
		{
			start = start.getNext();
			size--;
		}

	}

	public void deleteLast()
	{
		if(start == null)
			System.out.println("List is Empty.");
		else if(size ==1)
		{
			start = null;
			size--;
		}
		else
		{
			Node temp;
			temp = start;
			for(int i = 1; i < size -1 ; i++)
				temp = temp.getNext();
			temp.setNext(null);
			size--;
		}
	}

	public void deleteAtPosition(int position)
	{
		if(start == null)
			System.out.println("List is Empty.");

		else if(position < 1 || position > size)
			System.out.println("invalid Position");

		else if(position == 1)
			deleteFirst();

		else if(position == size)
			deleteLast();

		else
		{
			Node temp, temp1;
			temp = start;
			for(int i = 1; i < position -1; i++)
			{
				temp = temp.getNext();
			}
			temp1 = temp.getNext();
			temp.setNext(temp1.getNext());
			size--;
		}			

	}


	public void search(int value)
	{
		Node temp;
		temp = start;

		for(int i = 0; i < size-1; i++)
		{
			temp = temp.getNext();
			if(temp.getData() == value)
			{
				System.out.println(+value+" found at position "+i);
			}
		}
	}
}



public class LinkedList 
{

	public static void main(String[] args) 
	{
		LinkedListFunctions list1 = new LinkedListFunctions();
		boolean flag = true;
		while(flag)
		{
			System.out.println("1. Insert at first position\n2. insert at Last Position \n3. insert at Any Position\n"
					+ "4. DIsplay List\n5. Delete Firse\n6. Delete Last\n7. Delete any\n8. Search an Item\n9. Exit"
					+ "\nEnter your Choice: ");
			int choice = InputUtility.inputInteger();

			switch (choice) 
			{
			case 1:
				System.out.println("Enter Item");
				int item = InputUtility.inputInteger();
				list1.insertAtFirst(item);

				break;

			case 2:
				System.out.println("Enter Item");
				int item1 = InputUtility.inputInteger();
				list1.insertAtLast(item1);
				break;

			case 3:
				System.out.println("Enter Position to Enter Value: ");
				int pos = InputUtility.inputInteger();
				System.out.println("Enter Item");
				int item2 = InputUtility.inputInteger();
				list1.insertAtPosition(item2, pos);

				break;

			case 4:
				list1.display();
				break;

			case 5:
				list1.deleteFirst();
				break;

			case 6:
				list1.deleteLast();
				break;

			case 7:
				System.out.print("\nEnter Position to delete: ");
				int position = InputUtility.inputInteger();
				list1.deleteAtPosition(position);

				break;
				
			case 8:
				System.out.println("\nEnter Value You want to search: ");
				int val = InputUtility.inputInteger();
				list1.search(val);					
				break;

			case 9:
				flag = false;
				break;
			default:
				System.out.println("Invalid Position");
				break;
			}

		}

	}

}
