package spm.bjmh.policeman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spm.bjmh.policeman.model.policemanModel;
import spm.bjmh.policeman.repository.policemanRepository;

@SpringBootApplication
public class PolicemanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicemanApplication.class, args);
    }

    @Autowired
    private policemanRepository repository;

    public void run(String... args) throws Exception {
        repository.deleteAll();


//        private String id;
//        private String Name;
//        private String LastName;
//        private String idPoliceman;
//        private String Username;
//        private String Password;
//        private String PhoneNumber;
//        private String Email;
        // save a couple of customers
        repository.save(new policemanModel("1", "lulu", "cao", "00001", "caolulu", "123456", "3774541229", "caolulu@gmail.com"));
        repository.save(new policemanModel("2", "feifei", "liu", "00002", "liufeifei", "123456", "3774541221", "liufeifei@gmail.com"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (policemanModel Policeman : repository.findAll()) {
            System.out.println(Policeman);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("policeman found with findByFirstName('lulu'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("lulu"));

        System.out.println("policeman found with findByLastName('feifei'):");
        System.out.println("--------------------------------");
        for (policemanModel Policeman : repository.findByLastName("Smith")) {
            System.out.println(Policeman);

        }

    }
}
