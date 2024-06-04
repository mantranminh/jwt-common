package vn.kis.jwt.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import vn.kis.jwt.exceptions.InvalidJWTDataException;
import vn.kis.jwt.models.JwtPayloadDTO;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class JwtUtils {
    private static final Gson GSON = new Gson();

    /**
     *
     * @param validatedJwtToken Which is validated by Gateway
     * @return JwtPayloadDTO
     * @throws NullPointerException if validatedJwtToken is null
     * @throws ArrayIndexOutOfBoundsException if validatedJwtToken is not JWT format
     * @throws IllegalArgumentException if validatedJwtToken is not in valid Base64 scheme
     * @throws JsonSyntaxException if JWT data is not JSON well-formed
     * @throws InvalidJWTDataException if JWT data is missing required data
     */
    public static JwtPayloadDTO from(String validatedJwtToken) throws NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException, JsonSyntaxException, InvalidJWTDataException {
        Objects.requireNonNull(validatedJwtToken);
        JwtPayloadDTO p = GSON.fromJson(
                new String(Base64.getDecoder().decode(validatedJwtToken.split("\\.")[1]), StandardCharsets.UTF_8),
                JwtPayloadDTO.class);
        if (p.ud() == null || p.ud().username() == null) {
            throw new InvalidJWTDataException("Missing ud or username in JWT");
        }
        return p;
    }
}
