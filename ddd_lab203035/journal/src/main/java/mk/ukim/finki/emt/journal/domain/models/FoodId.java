package mk.ukim.finki.emt.journal.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.DomainObjectId;

public class FoodId extends DomainObjectId {

    protected FoodId(@NonNull String uuid) {
        super(uuid);
    }
}
