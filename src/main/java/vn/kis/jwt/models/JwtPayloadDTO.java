package vn.kis.jwt.models;

import java.util.List;

public record JwtPayloadDTO(String dm, int cId, List<Integer> sgIds, int lm, int uId, int rId,
                            UserDataDTO ud, List<Object> rls, String pl, String gt, String appV, Object sId, int iat, int exp) {
}
