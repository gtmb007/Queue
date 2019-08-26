import java.util.Scanner;
class CircularQueue {
	int front;
	int rear;
	int capacity;
	Integer[] arr;
	CircularQueue(int capacity) {
		this.front=-1;
		this.rear=-1;
		this.capacity=capacity;
		this.arr=new Integer[capacity];
	}
	boolean add(Integer data) {
		if((rear+1)%capacity==front) {
			return false;
		} else if(front==-1) {
			front++;
			arr[++rear]=data;
			return true;
		} else {
			rear=(rear+1)%capacity;
			arr[rear]=data;
			return true;
		}
	}
	Integer poll() {
		if(front==-1 || front>rear) {
			return null;
		} else if(front==rear) {
			Integer a=arr[front];
			front=-1;
			rear=-1;
			return a;
		} else {
			Integer a=arr[front];
			front=(front+1)%capacity;
			return a;
		}
	}
	Integer peek() {
                if(front==-1 || front>rear) {
                        return null;
                } else {
                        return arr[front];
                }
        }
	boolean contains(Integer data) {
		boolean flag=false;
                if(front>-1) {
                        for(int i=front;i<rear+size();i++) {
                                if(arr[i%capacity].equals(data)) {
					flag=true;
					break;
				}
                        }
                }
		return flag;
        }
	void display() {
		if(front==-1) {
			System.out.println("Queue is Empty");
		} else {
			for(int i=front;i<front+size();i++) {
				System.out.print(arr[i%capacity]+" ");
			}
			System.out.println();
		}
	}
	int size() {
		int count=0;
		if(front>-1) {
			count=(rear+capacity-front)%capacity+1;
                }
		return count;
	}
	int capacity() {
		return capacity-size();
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CircularQueue queue=new CircularQueue(10);
		System.out.println("© 2019 Gautam Bharadwaj");
		while(true) {
			System.out.println("\nCircular Queue Menu: \n1. Add an Element\n2. Poll an Element\n3. Peek an Element\n4. The Element is present or not\n5. Display the Queue\n6. Size of Queue\n7. Capacity of Queue \n8. Exit\n");
			System.out.print("Enter your choice: ");
			int option=sc.nextInt();
			switch(option) {
				case 1: System.out.print("Enter the element: ");
					System.out.println(queue.add(sc.nextInt()));
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
				case 7: System.out.println(queue.capacity());
                                        break;
				case 8: System.exit(0);
				default : System.out.println("Please enter correct choice!");
			}
		}
	}	
}
