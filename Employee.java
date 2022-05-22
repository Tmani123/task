package helloworld;
import java.util.*;

public class Employee {
	public static void main(String args[]) {
		Manager mng = new Manager();
		
		System.out.println("Enter option 1: addEmployee");
		System.out.println("Enter option 2: displayEmployee");
		System.out.println("Enter option 3: addBonus");
		System.out.println("Enter option 4: getEmployee");
		System.out.println("Enter option 5: incrementSalary");
		System.out.println("Enter option 6: allEmeployeeSalaries");
		System.out.println("Enter your option");
		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		switch(option) {
		case 1:
			mng.addEmployee();
			break;
		case 2:
			mng.displayEmployee();
			break;
		case 3:
			mng.addBonus();
			break;
		case 4:
			mng.getEmployee();
			break;
		case 5:
			mng.incrementSalary();
			break;
		case 6:
			mng.allEmeployeeSalaries();
			break;
		default:
			System.out.println("enter correct value");
			
		}
		
		
		
	}

}



