package com.example.jpa;

import com.example.jpa.model.Address;
import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaElementCollectionDemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaElementCollectionDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //cleanup database tables
        userRepository.deleteAll();
        
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("12345");
        phoneNumbers.add("54321");
        
        Set<String> position = new HashSet<>();
        position.add("Java Dev");
        position.add("PHP Dev");
        
        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("1-2","Jln.Boluevard","Kelapa Gading","jakarta Utara","Indonesia","21040"));
        addresses.add(new Address("2-3","Jln.Simatupang","BLOK M","jakarta Selatan","Indonesia","2847124"));
        
        User user = new User("Rocky M","Rockysarasimanalu@gmail.com",phoneNumbers,position,addresses);
        userRepository.save(user);
    }
}