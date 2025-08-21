package com.ocalender.ocalender_be.domain.group.groupclosure;

import com.ocalender.ocalender_be.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group_closure")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupClosure {

    @EmbeddedId
    private GroupClosureId idx; // 임베디드 id로 조상과 자손 테이블을 합쳐 embeddedid로 합쳐 하나의 컬럼 생성

    @ManyToOne(fetch = FetchType.LAZY) @MapsId("ancestorId")
    @JoinColumn(name = "ancestor_id", nullable = false)
    private Group ancestor; // 실제 생성 되지 않음

    @ManyToOne(fetch = FetchType.LAZY) @MapsId("descendantId")
    @JoinColumn(name = "descendant_id", nullable = false)
    private Group descendant; // 실제 생성되지 않음

    @Column(nullable = false)
    private int depth; // 0=self
}