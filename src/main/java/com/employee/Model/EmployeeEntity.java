package com.employee.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="employeetab")
@Table(name="employeetab")
public class EmployeeEntity {
		    @Id
		    private int Employee_Code;
		    private String Employee_Name;
	        private String Location;
			private String Email;
	        private String Date_of_Birth;
			public int getEmployee_Code() {
				return Employee_Code;
			}
			public void setEmployee_Code(int employee_Code) {
				Employee_Code = employee_Code;
			}
			public String getEmployee_Name() {
				return Employee_Name;
			}
			public void setEmployee_Name(String employee_Name) {
				Employee_Name = employee_Name;
			}
			public String getLocation() {
				return Location;
			}
			public void setLocation(String location) {
				Location = location;
			}
			public String getEmail() {
				return Email;
			}
			public void setEmail(String email) {
				Email = email;
			}
			public String getDate_of_Birth() {
				return Date_of_Birth;
			}
			public void setDate_of_Birth(String date_of_Birth) {
				Date_of_Birth = date_of_Birth;
			}
			@Override
			public String toString() {
				return "EmployeeEntity [Employee_Code=" + Employee_Code + ", Employee_Name=" + Employee_Name
						+ ", Location=" + Location + ", Email=" + Email + ", Date_of_Birth=" + Date_of_Birth + "]";
			}
			
		   
	}

