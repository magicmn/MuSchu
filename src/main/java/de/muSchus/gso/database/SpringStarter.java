package de.muSchus.gso.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringStarter {

    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(SpringStarter.class, args);
    }

    public static ApplicationContext getApplicationContext() {
        if (ctx == null) {
            main(new String[]{});
        }
        return ctx;
    }
}
