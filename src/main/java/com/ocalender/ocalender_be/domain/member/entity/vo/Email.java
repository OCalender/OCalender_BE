package com.ocalender.ocalender_be.domain.member.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {
    @NotBlank
    @jakarta.validation.constraints.Email
    @Column(name = "Email", length = 100)
    private String value;

    private Email(String value) {
        this.value = value;
    }

    /** 트림 + 소문자 정규화 */
    public static Email of(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("raw is null");
        }
        String v = raw.trim();
        if (v.isEmpty()) {
            throw new IllegalArgumentException("raw is empty");
        }
        return new Email(v);
    }
}
