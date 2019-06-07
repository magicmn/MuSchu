package de.muSchus.gso.web.component.stunde.model;

import de.muSchus.gso.database.entity.Dozent;
import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.repository.StundeRepository;
import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.general.MuSchuSession;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.Collection;

public class StundenTotalLDM extends LoadableDetachableModel<Collection<Stunde>> {

    @SpringBean
    private StundeRepository stundeRepository;

    public StundenTotalLDM() {
        Injector.get().inject(this);
    }

    @Override
    protected Collection<Stunde> load() {
        if (MuSchuSession.get().getRoles().hasRole(Rolle.LEHRER.name())) {
            Dozent dozent = (Dozent) MuSchuSession.get().getAccount();
            return stundeRepository.findAllByDozent(dozent);
        } else {
            return new ArrayList<>();
        }
    }
}
