package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "InvalidUserCredentials")
	public Object[][] userCredentialsData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "12345";

		data[1][0] = "abcder";
		data[1][1] = "123456";

		data[2][0] = "abcder";
		data[2][1] = "12345";

		return data;
	}

}
