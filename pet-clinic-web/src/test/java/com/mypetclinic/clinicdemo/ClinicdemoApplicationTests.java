package com.mypetclinic.clinicdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)//Lunit5 syntax
@SpringBootTest
public class ClinicdemoApplicationTests {

	@BeforeAll//Executed before all tests
	public static void generalInit() {
		
	}
	
	@BeforeEach// Executed before each test
	public void setUp() {
		
	}
    @AfterEach//Executed after each test --> cleanup
    public void clean() {
    	
    }
	
    @Test
    public void contextLoads() {
    }
    
    @AfterAll//Executed after all tests
    public static void generalCleanUp() {
    	
    }

}
