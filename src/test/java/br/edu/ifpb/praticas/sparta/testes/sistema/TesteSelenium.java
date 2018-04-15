/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.testes.sistema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sinbad Heinstein
 */
public class TesteSelenium {
    
    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void testaTituloDaPagina(){
        assertEquals("Welcome to the Spring MVC Quickstart application! Get started quickly by signing up!", driver.getTitle());
    }

    @Test
    public void testaLogin() throws InterruptedException {
        WebElement element = driver.findElement(By.id("login"));
        element.click();

        assertEquals("http://localhost:8080/sparta/login", driver.getCurrentUrl());

        Thread.sleep(2000L);
        element = driver.findElement(By.id("inputEmail"));
        element.sendKeys("admin");
        element = driver.findElement(By.id("inputPassword"));
        element.sendKeys("admin");
        element = driver.findElement(By.tagName("button"));
        Thread.sleep(2000L);
        element.click();
        assertEquals("http://localhost:8080/", driver.getCurrentUrl());
        element = driver.findElement(By.id("logout"));
        assertNotNull(element);
    }
    
}
