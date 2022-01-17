package edu.skku.ssopackage;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerifyResponseDto {
    private Integer result;

    @Builder
    public VerifyResponseDto(Integer nResult) {
        this.result = nResult;
    }
}
