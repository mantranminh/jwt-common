package utils;

import exceptions.InvalidJWTDataException;
import models.JwtPayloadDTO;

import static org.junit.Assert.*;

import org.junit.Test;

public class JwtUtilsUnitTest {

    @Test
    public void givenValidJWT_whenFrom_thenSuccess() {
        String validatedJWT = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkbSI6ImtpcyIsImNJZCI6MjUsInNnSWRzIjpbMSw1LDYsNyw4LDksMTAsMTIsMTUsMTYsMTcsMTgsMzUsMzYsMzcsMzhdLCJsbSI6MjAsInVJZCI6MjUyMTgsInJJZCI6NzE4NjY5MiwidWQiOnsiYWNjb3VudE51bWJlcnMiOlsiQzEwOTAyNlgxIl0sInR5cGUiOiJSRUdVTEFSIiwidXNlcm5hbWUiOiJDMTA5MDI2IiwibWFzRHJUb2tlbklkIjoidmVydHgtd2ViLnNlc3Npb249MzQzYWYyNWZhYTBlNTQ1MGQ2YTJhZGJhYWVlMTFiNDM7IFBhdGg9LzsgSFRUUE9ubHkiLCJtYXNFcXVpdHlUb2tlbklkIjoidmVydHgtd2ViLnNlc3Npb249MzQzYWYyNWZhYTBlNTQ1MGQ2YTJhZGJhYWVlMTFiNDM7IFBhdGg9LzsgSFRUUE9ubHkifSwicmxzIjpbXSwicGwiOiJXVFMuUEMiLCJndCI6InBhc3N3b3JkIiwiYXBwViI6IjEuMC40OSIsInNJZCI6bnVsbCwiaWF0IjoxNzE1OTIyODgyLCJleHAiOjE3MTU5NTE2ODJ9.q2cUXmshH2p1S4z165KRzEaZ03r5X_Rq7484Bfkvg1oHOXdYLg4eoqmQJbb8C_YdkXP3vqMWQuRltyilIOxGufWTVOEn-JtUXkEBwztot9fbHftsY5saCwZNlX_jdjHnhzxvSC1IEiTfh0habfxjVzZspxNZ_cIrebmT85TR5GQp5gmIKyk0gMGKUyF_WwSdIUBNPUyRZ_Wd1v3opSBLT4Zfm9F1RM-iVYB25uQ934a7Q_KNCrMpn8318Y1v51eqf6ADnvjpIcJz28uwmWzSRIH_oEbPd37wrWRh889JAPXXGUl3Hm8HU4a5TsYP5Dfwbz-tV4o0Xyb0pGVpVYU7v_VNSmh3PX-wmhWpYyWImp9vddfuQ-90yISgnxzmpsV3KBWMCCcxedxDUvbA4sRLqvxOIFHxZR2ZGHElZqAkZ-z3tPGzaQkI3jmbWm0AqKrnJ8Jl8pbvAe9_A0btr907jtzUKQejKjIQ1uBbrk8_YiYfcXGImHHBZIoqJTxWqADSq4Q1agivJf7KAvskbY70Wovh74AYZE73yE-yljb_AbACheM_XTqI-5rjZeydaSzVjMHpQD5-0QAm44nFvrNw27IXcevU4HukAGBcoxiPwKiuLBKUt_PWsqOdH7baNJo5d7Y_DiBV-9HwMaJQvNH8nBYZa28bcBRRo6T8h527FGo1";
        JwtPayloadDTO dto = JwtUtils.from(validatedJWT);
        assertNotNull(dto);
        assertNotNull("Has user data", dto.ud());
        assertNotNull("Has username", dto.ud().username());
    }

    @Test
    public void givenInvalidBase64_whenFrom_thenThrowIllegalArgumentException() {
        assertThrows("Throw IllegalArgumentException",
                IllegalArgumentException.class,
                () -> JwtUtils.from("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkbSI6Imtpc"));
    }

    @Test
    public void givenNullJWTToken_whenFrom_thenThrowNullPointerException() {
        assertThrows("Throw NullPointerException",
                NullPointerException.class,
                () -> JwtUtils.from(null));
    }

    @Test
    public void givenInvalidJWTToken_whenFrom_thenThrowArrayIndexOutOfBoundsException() {
        assertThrows("Throw IndexOutOfBoundsException",
                IndexOutOfBoundsException.class,
                () -> JwtUtils.from("Not a JWT"));
    }

    @Test
    public void givenInvalidJWTData_whenFrom_thenThrowInvalidJWTDataException() {
        assertThrows("Throw InvalidJWTDataException",
                InvalidJWTDataException.class,
                () -> JwtUtils.from("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"));
    }


}
