package woowaapplication.individual.moim.member.domain;

public enum Gender {
    MAN("M"),
    WOMAN("W"),
    ;

    private final String code;

    Gender(String code) {
        this.code = code;
    }
}
