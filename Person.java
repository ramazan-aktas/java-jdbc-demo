
public class Person extends DBAble{
	private int id;
	private String name;
	private int age;
	public String database_name = "java";
	public String table_name = "people";
	
	public Person() {
		this.setDbName(this.database_name);
		this.setTableName(this.table_name);
	}
	public Person(int id, String name, int age) {
		this.setDbName(this.database_name);
		this.setTableName(this.table_name);
		this.id = id;
		this.setId(id);
		this.name = name;
		this.age = age;
	}

	@Override
	public String dbReady() {
		return String.format("(%s, '%s', %s)", this.id, this.name, this.age);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
