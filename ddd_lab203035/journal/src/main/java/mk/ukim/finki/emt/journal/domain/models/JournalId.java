package mk.ukim.finki.emt.journal.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.DomainObjectId;

public class JournalId extends DomainObjectId {

    protected JournalId(@NonNull String uuid) {
        super(uuid);
    }
}
