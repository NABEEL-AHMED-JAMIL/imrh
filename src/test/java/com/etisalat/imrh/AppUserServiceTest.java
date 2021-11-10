package com.etisalat.imrh;

import com.etisalat.imrh.controller.AppUserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;

/**
 * @author Nabeel Ahmed
 */
public class AppUserServiceTest {

    public Logger logger = LogManager.getLogger(AppUserServiceTest.class);

    @InjectMocks
    private AppUserController appUserController;

    @Before
    public void setUp() throws Exception {
    }
}
