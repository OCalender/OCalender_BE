package com.ocalender.ocalender_be.domain.group;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "groups")
public class GroupMembership {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private MembershipRole role;
    // 멤버십의 역할을 정의 반드시 오너나 self 둘중 하나는 정의되며
    // 오너인 멤버십이 있는 경우에만 매니저와 유저 복수 생성 가능

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime joinedAt;
}
