package com.ocalender.ocalender_be.domain.member.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nickname {
    @NotBlank
    @Size(max = 50)
    @Column(name = "nickname", length = 50)
    private String value;

    private Nickname(String value) {
        this.value = value;
    }

    public static Nickname of(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("nickname is null");
        }
        String v = raw.trim();
        if (v.isEmpty()) {
            throw new IllegalArgumentException("nickname is empty");
        }
        if (v.length() > 50) {
            throw new IllegalArgumentException("nickname is too long");
        }
        return new Nickname(v);
    }

    @Override
    public String toString() {
        return value;
    }
}
