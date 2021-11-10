package com.etisalat.imrh;

import com.etisalat.imrh.controller.AppNotificationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;

/**
 * @author Nabeel Ahmed
 */
public class AppNotificationServiceTest {

    public Logger logger = LogManager.getLogger(AppNotificationServiceTest.class);

    @InjectMocks
    private AppNotificationController appNotificationController;

    @Before
    public void setUp() throws Exception {
    }
}
