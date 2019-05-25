package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.dao.impl.CustomerDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.logging.Logger;

public class Application {
    public static final Logger logger = Logger.getLogger("Application");

    public static void main(String[] args) {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        logger.info(customerDao.findAllByLastName("ln").toString());
    }
}
