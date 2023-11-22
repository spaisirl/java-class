package sql_exam;


public class SqlExamVo {
	private String sno; // 학번
	private String sname; // 이름
	private int syear; // 학년
	private String gender; // 성별
	private String major; // 전공
	private int score; // 점수
	

	public SqlExamVo(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	public SqlExamVo(String sno, String sname, Integer syear, String gender, String major, Integer score) {
	
		this(sno, sname);
		this.syear = syear;
		this.gender = gender;
		this.major = major;
		this.score = score;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSyear() {
		return syear;
	}
	public void setSyear(Integer syear) {
		this.syear = syear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "SqlExamVo [sno=" + sno + ", sname=" + sname + ", syear=" + syear + ", gender=" + gender + ", major="
				+ major + ", score=" + score + "]";
	}
	
	
}
