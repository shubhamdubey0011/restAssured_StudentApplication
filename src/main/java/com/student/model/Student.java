package com.student.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6918939819426414749L;

	public Student(){}
	
	public Student(String firtName, String lastName, String email, String programme,String[] courses ) {
		super();
		this.firstName = firtName;
		this.lastName = lastName;
		this.email = email;
		this.programme = programme;
		this.courses = courses;
	}

	 private String firstName;

	    private String lastName;

	    private String[] courses;

	    private String programme;

	    private String email;

	    public String getFirstName ()
	    {
	        return firstName;
	    }

	    public void setFirstName (String firstName)
	    {
	        this.firstName = firstName;
	    }

	    public String getLastName ()
	    {
	        return lastName;
	    }

	    public void setLastName (String lastName)
	    {
	        this.lastName = lastName;
	    }

	    public String[] getCourses ()
	    {
	        return courses;
	    }

	    public void setCourses (String[] courses)
	    {
	        this.courses = courses;
	    }

	    public String getProgramme ()
	    {
	        return programme;
	    }

	    public void setProgramme (String programme)
	    {
	        this.programme = programme;
	    }

	    public String getEmail ()
	    {
	        return email;
	    }

	    public void setEmail (String email)
	    {
	        this.email = email;
	    }

	    @Override
	    public String toString()
	    {
	        return "Student [firstName = "+firstName+", lastName = "+lastName+", courses = "+courses+", programme = "+programme+", email = "+email+"]";
	    }
	
}
