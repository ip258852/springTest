package org.test.service;

import org.springframework.stereotype.Service;

/**
 *  aop Service
 * Created by Kobeishandsome on 2018/9/21.
 */
@Service
public class AopTestService {

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    public void afterAdvice() {
        System.out.println("Student profile has been setup.");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
