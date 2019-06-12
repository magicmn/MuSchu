package de.muSchus.gso.web.page.verwaltung;


import de.muSchus.gso.web.component.stunde.list.StundenList;
import de.muSchus.gso.web.component.stunde.model.StundenWocheLDM;
import de.muSchus.gso.web.component.stunde.render.StundenListLehrerRenderer;
import de.muSchus.gso.web.general.page.BasePage;

public class DozentenStunden extends BasePage {

    public DozentenStunden(){
        initComponents();
    }

    public void initComponents(){

        add(new StundenList("dozentenliste", new StundenListLehrerRenderer("EEEE")).setModel(new StundenWocheLDM()));


    }

}
