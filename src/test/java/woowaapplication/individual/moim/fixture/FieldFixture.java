package woowaapplication.individual.moim.fixture;


public enum FieldFixture {
    식별자_아이디("id"),

    사용자_이름("name"),
    사용자_생년월일("birth"),
    사용자_성별("gender"),
    사용자_역할("role"),
    사용자_로그인_아이디("loginId"),
    사용자_비밀번호("password"),
    사용자_이메일("email"),

    모임_이름("name"),
    모임_주소("address"),
    모임_설명("description"),

    자기_소개("selfIntro"),
    알러지_재료("allergens"),
    ;

    private final String value;

    FieldFixture(String value) {
        this.value = value;
    }

    public String 필드명() {
        return value;
    }
}
