package de.muSchus.gso.database;

import org.apache.wicket.injection.Injector;

public class Testdata implements Runnable {

    private UserRepositroy userRepositroy = SpringStarter.getApplicationContext().getBean(UserRepositroy.class);

    public void run() {
        Injector.get().inject(this);
        User user = new User();
        user.setUsername("mmustermann");
        user.setVorname("Max");
        user.setNachname("Mustermann");
        user.setPassword("passwort");
        userRepositroy.save(user);
    }
}
