package mk.ukim.finki.emt.fitness_user.domain;


import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.DomainObjectId;

public class UserId extends DomainObjectId {
    protected UserId(@NonNull String uuid) {
        super(uuid);
    }
}
