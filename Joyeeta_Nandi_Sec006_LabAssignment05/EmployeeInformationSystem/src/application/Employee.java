package application;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class Employee {
	private int employeeId;
	private String name;
	private LocalDate dateOfJoining;
	private double salary;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(int employeeId, String name, LocalDate dateOfJoining, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "\t" + employeeId + "\t\t" + name + "\t\t" + dateOfJoining + "\t\t" + salary;
				//+ ", salary=" + salary + "]";
		//return "[employeeId, name, dateOfJoining, salary]";
			//+ ", salary=" + salary + "]";
		//return "[employeeId=" + employeeId + "\nname=" + name + ", dateOfJoining=" + dateOfJoining
			//	+ ", salary=" + salary + "]";
	}
	
}
