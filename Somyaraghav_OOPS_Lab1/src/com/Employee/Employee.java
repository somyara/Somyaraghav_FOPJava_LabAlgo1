package com.Employee;
import java.util.Scanner;
import com.interfaces.ICredential;

public class Employee implements ICredential{

	 private String firstName;
	 private String lastName;
	 private String password;
	 private String email;
	 private String department;
	 private String company="gl.com";
	 private int defaultPasswordLength=8;
	
	
	public Employee(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department=Department();
		this.password=generatePassword();
		this.email= generateEmailAddress(this.firstName,this.lastName);
		System.out.print("Dear " + this.firstName + " your generated credentials are as follows");
	}
	

	@Override
	public String Department() {
	System.out.print("Please Enter the Department from the following: \n1 Tech\n2 Admin\n3 Human Resource\n4 Legal\nEnter the department code:");
	Scanner i=new Scanner(System.in);
	int choice=i.nextInt();
	if(choice==1) 
	{
		return "Tech";
	}
	else if(choice==2) 
	{
		return "Admin";
	}
	else if(choice==3) 
	{
		return "HR";
	}
	else if(choice==4)
	{
		return "Legal";
	}
	else 
	{
		return "";
	}
}
	@Override
	public String generatePassword() 
	{
		String set= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
		char[] password=new char[defaultPasswordLength];
		for(int i=0;i<defaultPasswordLength;i++) 
		{
			int rand=(int) (Math.random()*set.length());
			password[i]=set.charAt(rand);
		}
		return new String(password);
	}
		
	@Override
	public String generateEmailAddress(String firstName, String lastName) 
	{
		email=firstName.toLowerCase()+""+lastName.toLowerCase()+"@" +department+"."+company;
		return email;

	}
	
	@Override 
	public String showCredentials() 
	{
		return "\nEmail----> "+email+
				"\nPassowrd--->"+password;
	}

}
