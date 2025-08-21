package com.ocalender.ocalender_be.domain.group;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "groups")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idx;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // 영속성 작업 전파 및 고아 객체 삭제
    private GroupMembership groupMembership;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 영속성 작업 전파 및 고아 객체 삭제
    private GroupClosure groupClosure;
}
