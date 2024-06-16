package com.venkat.xml.service;

import com.venkat.xml.employee.Employee;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Service
public class EmployeeProcessor {

    public Employee unmarshal(String xsdFile, String xmlFile) throws JAXBException, SAXException, IOException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdFile));
        unmarshaller.setSchema(schema);

        Employee employee = (Employee) unmarshaller.unmarshal(new File(xmlFile));

        Validator validator = schema.newValidator();
        validator.validate(new JAXBSource(context, employee));

        return employee;
    }

}
