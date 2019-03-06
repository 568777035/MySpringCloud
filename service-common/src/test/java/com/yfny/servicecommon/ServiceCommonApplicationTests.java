package com.yfny.servicecommon;

import com.yfny.servicecommon.generator.invoker.SingleInvoker;
import com.yfny.servicecommon.generator.invoker.base.Invoker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceCommonApplicationTests {

    @Test
    public void contextLoads() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .build();
        invoker.execute();
    }

}


