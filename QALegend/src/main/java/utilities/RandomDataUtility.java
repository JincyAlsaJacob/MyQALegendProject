package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	static Faker faker;
	public static String getFirstname()
	{
		faker=new Faker();
		String firstname=faker.name().firstName();
		return firstname;
	}
	public static String getLastname()
	{
		faker=new Faker();
		String lastname=faker.name().lastName();
		return lastname;
	}
	

}
