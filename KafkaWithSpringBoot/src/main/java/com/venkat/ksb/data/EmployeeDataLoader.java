package com.venkat.ksb.data;

import com.github.javafaker.Faker;

import com.venkat.ksb.model.Employee;
import com.venkat.ksb.service.EmployeeProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class EmployeeDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(EmployeeDataLoader.class);

    private final Faker faker;
    private final EmployeeProducer employeeProducer;

    public EmployeeDataLoader(Faker faker, EmployeeProducer employeeProducer) {
        this.faker = faker;
        this.employeeProducer = employeeProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Employee Data...");
        List<Employee> employees = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Employee(faker.name().firstName(),
                        faker.name().lastName(),
                        "Software Engineer",
                        "VV-" + faker.number().digits(5)
                        )
                ).toList();

        employees.forEach(emp -> {
            this.employeeProducer.publishMessage(emp);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

   /* @Bean
    public NewTopic createTopic(){//which creates the new topic
        return new NewTopic("emp-topic", 5, (short)1);
    }*/
}
