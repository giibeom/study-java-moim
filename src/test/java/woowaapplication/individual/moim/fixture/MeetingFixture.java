package woowaapplication.individual.moim.fixture;

import java.util.HashMap;
import java.util.Map;

import static woowaapplication.individual.moim.fixture.FieldFixture.*;

public enum MeetingFixture {

    드럼_모임("드럼 모임", "서울시 강남구", "드럼을 치고 싶은 사람들을 위한 모임"),
    모각코_모임("모각코 모임", "경기도 안양시", "모여서 각자 코딩하는 모임"),
    ;

    private final String name;
    private final String address;
    private final String description;

    MeetingFixture(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public String 이름() {
        return name;
    }

    public String 주소() {
        return address;
    }

    public String 설명() {
        return description;
    }

    public Map<String, String> 모임_등록_요청_데이터_생성(Map<String, String> data) {
        data.put(모임_이름.필드명(), 이름());
        data.put(모임_주소.필드명(), 주소());
        data.put(모임_설명.필드명(), 설명());
        return data;
    }
}
