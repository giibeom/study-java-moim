package woowaapplication.individual.moim.acceptance.support;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import woowaapplication.individual.moim.fixture.MeetingFixture;
import woowaapplication.individual.moim.fixture.MemberFixture;
import woowaapplication.individual.moim.fixture.ParticipantFixture;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static woowaapplication.individual.moim.utils.JsonPathUtil.Location_추출;

public class MemberSupporter {

    public static final String MEMBER_BASE_URL = "/api/v1/members";
    public static final String 주최자_등록_Path = MEMBER_BASE_URL + "/host";
    public static final String 참여자_등록_Path = MEMBER_BASE_URL + "/participant";

    // =========== 요청 메서드 ===========
    public static ExtractableResponse<Response> 주최자_회원_등록_요청(MemberFixture 회원_정보, MeetingFixture 모임_정보) {
        return given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(회원_정보.주최자_회원_등록_요청_데이터_생성(모임_정보))
                .when().post(주최자_등록_Path)
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 참여자_회원_등록_요청(MemberFixture 회원_정보, ParticipantFixture 참여자_정보) {
        return given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(회원_정보.참여자_회원_등록_요청_데이터_생성(참여자_정보))
                .when().post(참여자_등록_Path)
                .then().log().all().extract();
    }


    // =========== 겸증 메서드 ===========
    public static void 등록된_회원_ID를_포함한_Location이_반환된다(ExtractableResponse<Response> 회원_등록_결과, String 요청_Path) {
        assertThat(Location_추출(회원_등록_결과)).matches("^" + 요청_Path + "/[0-9]+$");
    }
}
