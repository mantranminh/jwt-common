package vn.kis.jwt.models;

import java.util.List;

public record UserDataDTO(List<String> accountNumbers, String type, String username,
                          String masDrTokenId, String masEquityTokenId) {
}