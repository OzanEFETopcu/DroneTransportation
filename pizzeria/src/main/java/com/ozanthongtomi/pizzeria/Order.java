package com.ozanthongtomi.pizzeria;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @NonNull
    private Long id;

    @NotNull
    private String name;

}
