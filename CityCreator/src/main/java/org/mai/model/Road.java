package org.mai.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Road {
    private String from;
    private String to;
    private int cost;
}
