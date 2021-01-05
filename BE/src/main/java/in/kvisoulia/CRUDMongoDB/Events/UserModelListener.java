package in.kvisoulia.CRUDMongoDB.Events;

import in.kvisoulia.CRUDMongoDB.Model.Employee;
import in.kvisoulia.CRUDMongoDB.Services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class UserModelListener extends AbstractMongoEventListener<Employee> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Employee.SEQUENCE_NAME));
        }
    }


}