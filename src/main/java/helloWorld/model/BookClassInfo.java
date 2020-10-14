package helloWorld.model;

public class BookClassInfo {

	private Integer classId;
	private Integer classType;
	private String description;
	
	public BookClassInfo() {};
	public BookClassInfo(Integer classId, Integer classType, String description) {
		this.classId = classId;
		this.classType = classType;
		this.description = description;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassType() {
		return classType;
	}
	public void setClassType(Integer classType) {
		this.classType = classType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
