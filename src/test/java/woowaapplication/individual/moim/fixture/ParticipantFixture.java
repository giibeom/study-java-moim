package woowaapplication.individual.moim.fixture;

import java.util.Map;

import static woowaapplication.individual.moim.fixture.FieldFixture.*;

public enum ParticipantFixture {
    기범_정보("안녕하세요 기범입니다. 27살이고 MBTI는 ESTJ입니다. 잘부탁드립니다!!",
            "1,2,3,4,5,6,7,8"),
    알렉스_정보("Hi I'm Alex. Nice to meet you. I'm programmer developer!",
            "10,11,12,13,14,15,16,17"),
    ;

    private final String selfIntro;
    private final String allergens;

    ParticipantFixture(String selfIntro, String allergens) {
        this.selfIntro = selfIntro;
        this.allergens = allergens;
    }

    public String 자기소개() {
        return selfIntro;
    }

    public String 알러지재료() {
        return allergens;
    }

    public Map<String, String> 참여자_등록_요청_데이터_생성(Map<String, String> data) {
        data.put(자기_소개.필드명(), 자기소개());
        data.put(알러지_재료.필드명(), 알러지재료());
        return data;
    }
}
