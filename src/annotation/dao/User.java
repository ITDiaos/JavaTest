package annotation.dao;

@Entity(getTableName = "bbs_user")
public class User {
	@Column(getName = "user_id")
	private String id;
	@Column(getName = "user_name")
	private String name;
	@Column(getName = "user_age")
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
