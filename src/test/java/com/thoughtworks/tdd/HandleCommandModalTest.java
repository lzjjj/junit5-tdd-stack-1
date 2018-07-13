package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class HandleCommandModalTest {
    @Test
    public void should_print_something_when_input_given_is_string() {

        //given
        String commandStr = "2";
        //when
        HandleCommandModal entrance = new HandleCommandModal(commandStr);
        //then
        assertThat(entrance.bulidResult(), not("停车"));


    }
}
