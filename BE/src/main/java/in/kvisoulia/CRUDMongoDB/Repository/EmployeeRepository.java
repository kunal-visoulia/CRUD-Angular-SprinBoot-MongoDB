package in.kvisoulia.CRUDMongoDB.Repository;

import java.util.List;

import in.kvisoulia.CRUDMongoDB.Model.Employee;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}