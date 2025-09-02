package com.ocalender.ocalender_be.domain.group.entity;

import com.ocalender.ocalender_be.domain.schedule.Schedule;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY)
    private GroupMembership groupMembership;

    // 클로저 매핑
    @OneToMany(mappedBy = "ancestor_id", fetch = FetchType.LAZY)
    private Set<GroupClosure> descendants = new HashSet<>();

    @OneToMany(mappedBy = "descendant_id", fetch = FetchType.LAZY)
    private Set<GroupClosure> ancestors = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY) // 연쇄삭제
    private List<Schedule>  schedules = new ArrayList<>();
}
