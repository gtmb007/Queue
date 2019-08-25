import java.util.Scanner;
class Node {
	Integer data;
	Node next;
	Node(Integer data) {
		this.data=data;
	}	
}
class Queue {
	Node front;
	Node rear;
	void add(Integer data) {
		Node newNode=new Node(data);
		if(front==null) {
			front=newNode;
			rear=newNode;
		} else {
			rear.next=newNode;
			rear=newNode;
		}
	}
	Integer poll() {
		if(front==null) {
			return null;
		} else {
			Integer a=front.data;
			front=front.next;
			return a;
		}
	}
	Integer peek() {
		if(front==null) {
			return null;
		} else {
			return front.data;
		}
	}
	boolean contains(Integer data) {
		boolean flag=false;
		Node temp=front;
		while(temp!=null) {
			if(temp.data.equals(data)) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		return flag;
	}
	void display() {
		if(front==null) {
			System.out.println("Queue is Empty");	
		} else {
			Node temp=front;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	int size() {
		int count=0;
		Node temp=front;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue queue=new Queue();
		System.out.println("© 2019 Gautam Bharadwaj");
		while(true) {
			System.out.println("\nQueue Using Linked List Menu: \n1. Add an Element\n2. Poll an Element\n3. Peek an Element\n4. The Element is present or not\n5. Display the Queue\n6. Size of Queue\n7. Exit\n");
			System.out.print("Enter your choice: ");
			int option=sc.nextInt();
			switch(option) {
				case 1: System.out.print("Enter the element: ");
					queue.add(sc.nextInt());
					break;
				case 2: System.out.println(queue.poll());
					break;
				case 3: System.out.println(queue.peek());
					break;
				case 4: System.out.print("Enter the element: ");
					System.out.println(queue.contains(sc.nextInt()));
					break;
				case 5: queue.display();
					break;
				case 6: System.out.println(queue.size());
					break;
				case 7: System.exit(0);
				default : System.out.println("Please enter correct choice!");
			}
		}
	}	
}
