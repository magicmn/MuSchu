package de.muSchus.gso.web.page.verwaltung;

import de.muSchus.gso.web.bootstrap.page.BasePage;
import de.muSchus.gso.web.panel.stunde.list.StundenList;
import de.muSchus.gso.web.panel.stunde.model.StundenWocheLDM;
import org.apache.wicket.model.ResourceModel;

public class DozentenStunden extends BasePage {

    public DozentenStunden(){
        initComponents();
    }

    public void initComponents(){

        add(new StundenList("dozentenliste", "EEEE",new ResourceModel("Stunde.woche"), new StundenWocheLDM()));


    }

}
