package woowaapplication.individual.moim.fixture;

import java.util.HashMap;
import java.util.Map;

import static woowaapplication.individual.moim.fixture.FieldFixture.*;

public enum MemberFixture {

    회원_기범("기범", "19970707", "M", "H",
            "kpmyoung", "테스트는재밌다97", "kpmyung@gmail.com"
    ),
    회원_알렉스("알렉스", "19970727", "M", "P",
            "gbmyoung", "테스트는중요하다97", "dev.gibeom@gmail.com"
    ),
    ;

    private final String name;
    private final String birth;
    private final String gender;
    private final String type;
    private final String loginId;
    private final String password;
    private final String email;

    MemberFixture(String name, String birth, String gender, String type, String loginId, String password, String email) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.type = type;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }

    public String 이름() {
        return name;
    }

    public String 생년월일() {
        return birth;
    }

    public String 성별() {
        return gender;
    }

    public String 역할() {
        return type;
    }

    public String 로그인_아이디() {
        return loginId;
    }

    public String 비밀번호() {
        return password;
    }

    public String 이메일() {
        return email;
    }

    public Map<String, String> 회원_등록_요청_데이터_생성() {
        Map<String, String> data = new HashMap<>();
        data.put(사용자_이름.필드명(), 이름());
        data.put(사용자_생년월일.필드명(), 생년월일());
        data.put(사용자_성별.필드명(), 성별());
        data.put(사용자_로그인_아이디.필드명(), 로그인_아이디());
        data.put(사용자_비밀번호.필드명(), 비밀번호());
        data.put(사용자_이메일.필드명(), 이메일());
        return data;
    }

    public Map<String, String> 주최자_회원_등록_요청_데이터_생성(MeetingFixture 모임) {
        return 모임.모임_등록_요청_데이터_생성(회원_등록_요청_데이터_생성());
    }

    public Map<String, String> 참여자_회원_등록_요청_데이터_생성(ParticipantFixture 참여자) {
        return 참여자.참여자_등록_요청_데이터_생성(회원_등록_요청_데이터_생성());
    }
}
