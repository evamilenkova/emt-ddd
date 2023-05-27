package mk.ukim.finki.emt.sharedkernel.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Embeddable
public class Number implements ValueObject {
    private final double number;
    protected Number(){
        this.number=0.0;
    }
    public Number(@NonNull double n){
        this.number=n;
    }
}
