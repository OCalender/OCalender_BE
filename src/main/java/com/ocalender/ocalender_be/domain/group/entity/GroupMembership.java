package com.ocalender.ocalender_be.domain.group.entity;


import com.ocalender.ocalender_be.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "group_membership")
public class GroupMembership {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idx;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipRole role;
    // 멤버십의 역할을 정의 반드시 오너나 self 둘중 하나는 정의되며
    // 오너인 멤버십이 있는 경우에만 매니저와 유저 복수 생성 가능
    // 비즈니스 로직단에서 구현 예정

    @OneToMany(fetch = FetchType.LAZY)
    private List<Member> member = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime joinedAt;
}
