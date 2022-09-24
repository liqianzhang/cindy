package com.jiayu;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
class AopTestTest {
    @Autowired
    AopTest aopTest;

    @Test
    void downLoad() {
        aopTest.downLoad();
    }
}