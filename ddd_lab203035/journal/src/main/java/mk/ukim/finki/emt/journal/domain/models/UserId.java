package mk.ukim.finki.emt.journal.domain.models;


import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.DomainObjectId;

public class UserId extends DomainObjectId {
    protected UserId(@NonNull String uuid) {
        super(uuid);
    }
}
