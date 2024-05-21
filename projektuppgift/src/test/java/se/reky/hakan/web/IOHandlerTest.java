package se.reky.hakan.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.IOHandler;

import java.util.Scanner;

public class IOHandlerTest {


    private IOHandler ioHandlerReturnsInt (){
        return new IOHandler(new Scanner("55"));
    }


    @Test
    @DisplayName("IOHandler method returns an int")
    public void ioHandlerReturnsAnInt(){
        boolean itDoesHaveNextInt = ioHandlerReturnsInt().hasNextInt();
        Assertions.assertTrue(itDoesHaveNextInt);
    }
}