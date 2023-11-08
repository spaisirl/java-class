package ex03;

public class Student extends Person {
	private String grade;
	private String department;
	
	public Student() {
		super();
	}

	public Student(String grade, String department) {
		super();
		this.grade = grade;
		this.department = department;
	}

	public String getGrade() { // 값을 가져온다.
		return grade;
	}

	public void setGrade(String grade) { // 값을 설정한다.
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", department=" + department + "]";
	}

	
	

}


