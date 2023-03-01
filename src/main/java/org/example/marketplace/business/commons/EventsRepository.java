package org.example.marketplace.business.commons;

import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregatedRootId(String aggregatedRootId);

}
