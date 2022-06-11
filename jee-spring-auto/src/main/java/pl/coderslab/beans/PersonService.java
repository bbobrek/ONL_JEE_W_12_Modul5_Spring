package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepo;

    @Autowired
    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public PersonRepository getPersonRepo() {
        return personRepo;
    }

}
