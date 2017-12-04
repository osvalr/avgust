package com.acme.test;

import com.acme.commons.repository.service.ICatalogoRepository;
import com.acme.jpa.domain.CatalogoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = { "classpath:spring-database-config.xml" })
public class TestSpring extends AbstractTestNGSpringContextTests {


    @Autowired
    ICatalogoRepository iCatalogoRepository;

    @Test()
    void test() {

        try{
            List<CatalogoEntity> list = iCatalogoRepository.getAll();
            System.out.println(list.toString());
        }catch (Exception e){
            System.out.println("error");
        }


    }

}
