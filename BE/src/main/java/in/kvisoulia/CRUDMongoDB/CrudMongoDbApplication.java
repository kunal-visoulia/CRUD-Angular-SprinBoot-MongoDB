package in.kvisoulia.CRUDMongoDB;


import in.kvisoulia.CRUDMongoDB.Model.Employee;
import in.kvisoulia.CRUDMongoDB.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudMongoDbApplication {
	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CrudMongoDbApplication.class, args);
	}

	// implements CommandLineRunner then override
//	@Override
//	public void run(String... args) throws Exception {
//
//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new Employee("Alice", "Smith","alicesmih@email.com"));
//		repository.save(new Employee("Bob", "Smith","bobsmith@email.com"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Employee customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Employee customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
//
//	}
}