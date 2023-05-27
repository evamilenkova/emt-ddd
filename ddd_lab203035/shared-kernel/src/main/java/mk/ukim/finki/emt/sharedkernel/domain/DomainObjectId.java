package mk.ukim.finki.emt.sharedkernel.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {
    private String id;

    @JsonCreator
    protected DomainObjectId(@NonNull String uuid) {
        this.id = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    protected DomainObjectId(){}

    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }
}
