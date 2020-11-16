public class City implements Comparable<City>{
	private String name;
	private float temperature;
	
	public City(String name, float temperature) {
		this.name = name;
		this.temperature = temperature;
	}
	
	public String getName() {
		return name;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@Override
	public int compareTo(City other) {
		return name.compareTo(other.getName());
	}		
	
	public String toString() {
		String message = "The city " + name + " is measuring " 
					     + temperature + " F";
		return message;
	}
	
}
