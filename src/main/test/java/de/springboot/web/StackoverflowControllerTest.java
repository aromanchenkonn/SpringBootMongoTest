package de.springboot.web;

import com.google.common.collect.ImmutableList;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.service.StackoverflowService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
/*
* Юнит тест
* */
@RunWith(MockitoJUnitRunner.class)
public class StackoverflowControllerTest {
    @Mock
    private StackoverflowService stackoverflowService;
    @InjectMocks
    StackoverflowController sut;

    @Test
    public void getListOfProviders() throws Exception {
        //prepare
        when(stackoverflowService.findAll()).thenReturn(ImmutableList.of());
        //testing
        List<StackoverflowWebsite> listOfProviders = sut.getListOfProviders();
        //validate
        Mockito.verify(stackoverflowService).findAll();

        /*
        * валидность теста проверяем на null -> вернем null в методе;
        * будет сообщение :
        *       Wanted but not invoked:
        *       stackoverflowService.findAll();
        * */
    }
}