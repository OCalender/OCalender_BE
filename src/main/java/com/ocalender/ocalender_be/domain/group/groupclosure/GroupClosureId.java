package com.ocalender.ocalender_be.domain.group.groupclosure;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupClosureId implements Serializable {
    @Column(name = "ancestor_id")
    private Long ancestorId;
    @Column(name = "descendant_id")
    private Long descendantId;
}
