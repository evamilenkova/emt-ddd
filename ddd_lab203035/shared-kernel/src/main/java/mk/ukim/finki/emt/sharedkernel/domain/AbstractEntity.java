package mk.ukim.finki.emt.sharedkernel.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId> {

    @EmbeddedId
    private ID id;


}
