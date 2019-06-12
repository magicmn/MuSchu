package de.muSchus.gso.web.component.kursTyp.model;

import de.muSchus.gso.database.entity.KursTyp;
import de.muSchus.gso.database.repository.KursTypRepository;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.domain.Sort;

import java.util.Collection;

public class AllKuryTypLDM extends LoadableDetachableModel<Collection<KursTyp>> {

    @SpringBean
    private KursTypRepository kursTypRepository;

    @Override
    protected Collection<KursTyp> load() {
        return kursTypRepository.findAll(Sort.by("bezeichnung"));
    }
}
