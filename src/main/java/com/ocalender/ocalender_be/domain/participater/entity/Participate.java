package com.ocalender.ocalender_be.domain.participater.entity;


import com.ocalender.ocalender_be.domain.member.entity.Member;
import com.ocalender.ocalender_be.domain.schedule.Schedule;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "participatese")
public class Participate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @OneToOne(fetch = FetchType.LAZY)
    Schedule schedule;
}
