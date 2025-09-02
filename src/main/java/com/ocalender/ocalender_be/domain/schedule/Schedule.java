package com.ocalender.ocalender_be.domain.schedule;

import com.ocalender.ocalender_be.domain.group.entity.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idx;

    @Column(nullable = false)
    private LocalDate startDateTime;

    @Column(nullable = false)
    private LocalDate endDateTime;

    @OneToOne(fetch = FetchType.LAZY)
    private ScheduleContent  scheduleContent;
}
