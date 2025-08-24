package com.ocalender.ocalender_be.domain.member.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {
    @NotBlank
    @Size(min = 60, max = 100) // BCrypt=60, Argon2 등은 더 길 수 있어 여유
    @Column(name = "password", nullable = false, length = 100)
    private String value;

    private Password(String hashed) {
        this.value = hashed;
    }

    /** 이미 해시된 값을 래핑 */
    public static Password fromHashed(String hashed) {
        if (hashed == null || hashed.isBlank())
            throw new IllegalArgumentException("hashed password is blank");
        return new Password(hashed);
    }

    /** 원문을 해시하여 생성 (스프링 PasswordEncoder 등 함수 주입) */
    public static Password fromRaw(String raw, Function<String, String> hasher) {
        if (raw == null || raw.isBlank())
            throw new IllegalArgumentException("raw password is blank");
        if (hasher == null) throw new IllegalArgumentException("hasher is null");
        String hashed = hasher.apply(raw);
        return fromHashed(hashed);
    }

    @Override public String toString() { return "********"; } // 노출 방지
}
