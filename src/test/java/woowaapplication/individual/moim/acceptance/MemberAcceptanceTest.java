package woowaapplication.individual.moim.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.springframework.http.MediaType;
import woowaapplication.individual.moim.acceptance.support.AcceptanceTest;

import static io.restassured.RestAssured.given;
import static woowaapplication.individual.moim.acceptance.support.CommonSupporter.등록에_성공한다;
import static woowaapplication.individual.moim.acceptance.support.CommonSupporter.잘못된_요청으로_인해_요청에_실패한다;
import static woowaapplication.individual.moim.acceptance.support.MemberSupporter.*;
import static woowaapplication.individual.moim.fixture.MeetingFixture.드럼_모임;
import static woowaapplication.individual.moim.fixture.MemberFixture.회원_기범;
import static woowaapplication.individual.moim.fixture.MemberFixture.회원_알렉스;
import static woowaapplication.individual.moim.fixture.ParticipantFixture.알렉스_정보;

@DisplayName("회원 기능 인수 테스트")
public class MemberAcceptanceTest extends AcceptanceTest {

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 회원_등록_시 {

        @Nested
        @DisplayName("주최자로 회원을 등록할 때")
        class Context_with_create_member_as_host {

            @Test
            @DisplayName("소속 정보가 없을 경우 회원 등록에 실패한다")
            void it_responses_400() {
                ExtractableResponse<Response> 회원_등록_결과 = given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(회원_기범.회원_등록_요청_데이터_생성())
                        .when().post(주최자_등록_Path)
                        .then().log().all().extract();

                잘못된_요청으로_인해_요청에_실패한다(회원_등록_결과);
            }

            @Test
            @DisplayName("유효한 정보일 경우 회원 등록에 성공한다")
            void it_member_registration_was_successful() {
                ExtractableResponse<Response> 회원_등록_결과 = 주최자_회원_등록_요청(회원_기범, 드럼_모임);

                등록에_성공한다(회원_등록_결과);
                등록된_회원_ID를_포함한_Location이_반환된다(회원_등록_결과, 주최자_등록_Path);
            }

            @Nested
            @DisplayName("회원 등록에 성공할 경우")
            @Disabled
            class Context_with_success_member_created {

                @BeforeEach
                void setUp() {
                    ExtractableResponse<Response> 회원_등록_결과 = 주최자_회원_등록_요청(회원_기범, 드럼_모임);
                }

                @Test
                @DisplayName("로그인 성공 시 내 정보를 조회할 때 소속을 포함한 주최자 회원 정보가 조회된다")
                void it_returns_host_member_info() {

                }

                @Test
                @DisplayName("로그인 실패 시 내 정보를 조회에 실패한다")
                void it_responses_401() {

                }
            }
        }

        @Nested
        @DisplayName("참가자로 회원을 등록할 때")
        class Context_with_create_member_as_participant {

            @Test
            @DisplayName("자기소개와 알러지 재료 정보가 없을 경우 회원 등록에 실패한다")
            void it_responses_400() {
                ExtractableResponse<Response> 회원_등록_결과 = given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(회원_알렉스.회원_등록_요청_데이터_생성())
                        .when().post(참여자_등록_Path)
                        .then().log().all().extract();

                잘못된_요청으로_인해_요청에_실패한다(회원_등록_결과);
            }

            @Test
            @DisplayName("유효한 정보일 경우 회원 등록에 성공한다")
            void it_member_registration_was_successful() {
                ExtractableResponse<Response> 회원_등록_결과 = 참여자_회원_등록_요청(회원_알렉스, 알렉스_정보);

                등록에_성공한다(회원_등록_결과);
                등록된_회원_ID를_포함한_Location이_반환된다(회원_등록_결과, 주최자_등록_Path);
            }

            @Nested
            @DisplayName("회원 등록에 성공할 경우")
            @Disabled
            class Context_with_success_member_created {

                @BeforeEach
                void setUp() {

                }

                @Test
                @DisplayName("로그인 성공 시 내 정보를 조회할 때 자기소개와 알러지 재료 정보를 포함한 참여자 회원 정보가 조회된다")
                void it_returns_participant_member_info() {

                }

                @Test
                @DisplayName("로그인 실패 시 내 정보를 조회에 실패한다")
                void it_responses_401() {

                }
            }
        }
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    @Disabled
    class 로그인_시 {

        @BeforeEach
        void setUp() {

        }

        @Test
        @DisplayName("등록한 정보로 로그인 할 경우 인증 토큰이 반환된다")
        void it_returns_auth_token() {

        }

        @Test
        @DisplayName("다른 정보로 로그인 할 경우 로그인에 실패한다")
        void it_responses_401() {

        }
    }
}
