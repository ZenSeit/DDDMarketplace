package org.example.marketplace.business.commons;

import org.example.marketplace.generic.Command;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public interface UseCaseForCommand <T extends Command>{

    List<DomainEvent> apply(T command);

}
