package com.venkat.xml.service;

import com.venkat.xml.employee.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeProcessorTest {

    @Autowired
    private EmployeeProcessor processor;

    @Test
    public void unmarshalTest(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            URL xsdUrl = classLoader.getResource("schemas/xsd/employee.xsd");
            URL xmlUrl = classLoader.getResource("employee.xml");

            System.out.println("xsdUrl: " + xsdUrl);
            System.out.println("xmlUrl: " + xmlUrl);

            assertNotNull(xsdUrl, "XSD file not found");
            assertNotNull(xmlUrl, "XML file not found");

            String xsdFile = new File(xsdUrl.getFile()).getAbsolutePath();
            String xmlFile = new File(xmlUrl.getFile()).getAbsolutePath();

            Employee employee = processor.unmarshal(xsdFile, xmlFile);
            System.out.println("Id: " + employee.getId());
            System.out.println("FirstName: " + employee.getFirstName());
            System.out.println("LastName: " + employee.getLastName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Salary: " + employee.getSalary());

            assertEquals(1, employee.getId(), "ID should be 1");
            assertEquals("Venkatram", employee.getFirstName(), "First name should be John");
            assertEquals("Veerareddy", employee.getLastName(), "Last name should be Doe");
            assertEquals("IT", employee.getDepartment(), "Department should be Engineering");
            assertEquals(new BigDecimal(40000.00), employee.getSalary(), "Salary should be 40000.00");
        } catch (JAXBException | SAXException | IOException e) {
            //e.printStackTrace();
            System.out.println("Error : " + e.getCause());
        }
    }


}