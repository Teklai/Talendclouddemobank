package beans;

import org.apache.camel.Handler;
import com.github.javafaker.Faker;

import beans.AddressBookProtos.Person;
import beans.AddressBookProtos.Person.PhoneType;

public class GenerateAddressBookProtos {
	// Uses Faker to generate some sample data.
	
	// The default Bean handler - creates a new Person.
	@Handler
	public static Person generate() {	
		String firstName = Faker.instance().name().firstName();

		AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
				.setName(firstName)
				.setEmail(firstName.toLowerCase() + "@example.com")
				.addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
						.setNumber(Faker.instance().phoneNumber().cellPhone())
						.setType(PhoneType.forNumber(
								Faker.instance().number().numberBetween(0, 3))))
				.build();

		return person;
	}
}
