package de.muSchus.gso.web.component.stunde.model;

import de.muSchus.gso.database.entity.Dozent;
import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.repository.StundeRepository;
import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.general.MuSchuSession;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StundenWocheLDM extends LoadableDetachableModel<Collection<Stunde>> {

    @SpringBean
    private StundeRepository stundeRepository;

    public StundenWocheLDM() {
        Injector.get().inject(this);
    }

    @Override
    protected List<Stunde> load() {
        LocalDateTime start = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDateTime end = LocalDateTime.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        if (MuSchuSession.get().getRoles().hasRole(Rolle.LEHRER.name())) {
            Dozent dozent = (Dozent) MuSchuSession.get().getAccount();
            return stundeRepository.findAllByDozentAndDatumBetween(dozent, start, end);
        } else {
            return new ArrayList<>();
        }
    }
}
