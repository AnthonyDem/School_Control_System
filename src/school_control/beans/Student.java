package school_control.beans;

public class Student {
	private int id;
	private String name;
	private float avgMark;
	private String parent;
	
	public Student() {
		
	}
	
	public Student(int id, String name, float avgMark, String parent) {
		this.id = id;
		this.name = name;
		this.avgMark = avgMark;
		this.parent = parent;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getAvgMark() {
		return avgMark;
	}
	
	public void setAvgMark(float avgMark) {
		this.avgMark = avgMark;
	}
	
	public String getParent() {
		return parent;
	}
	
	public void setParent (String parent) {
		this.parent = parent;
	}

}
