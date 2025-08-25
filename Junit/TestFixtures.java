package junit;

import org.junit.jupiter.api.*;

public class TestFixtures {
 
    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll: Run once before all test methods");
    }
 
    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach: Run before each test method");
    }
 
    @AfterEach
    void afterEach() {
        System.out.println("AfterEach: Run after each test method");
    }
 
    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll: Run once after all test methods");
    }
 
    @Test
    void test1() {
        System.out.println("Executing test1");
    }
 
    @Test
    void test2() {
        System.out.println("Executing test2");
    }
}