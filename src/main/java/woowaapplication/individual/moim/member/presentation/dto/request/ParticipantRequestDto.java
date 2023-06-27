package woowaapplication.individual.moim.member.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import woowaapplication.individual.moim.common.utils.DateConverter;
import woowaapplication.individual.moim.participant.domain.Allergens;
import woowaapplication.individual.moim.meeting.domain.Meeting;
import woowaapplication.individual.moim.participant.domain.Participant;
import woowaapplication.individual.moim.member.application.command.ParticipantRequest;
import woowaapplication.individual.moim.member.domain.Gender;
import woowaapplication.individual.moim.member.domain.Member;
import woowaapplication.individual.moim.member.domain.MemberRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static woowaapplication.individual.moim.member.domain.MemberRole.HOST;

@Getter
public class ParticipantRequestDto implements ParticipantRequest {
    // Member(회원)
    @NotBlank(message = "회원 이름을 입력해주세요.")
    private final String memberName;

    @NotBlank(message = "생년월일을 입력해주세요.")
    private final String birth;

    @NotBlank(message = "성별을 입력해주세요.")
    private final String gender;

    private final MemberRole role = HOST;

    @NotBlank(message = "로그인 아이디를 입력해주세요.")
    private final String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{7,}$", message = "비밀번호는 문자와 숫자가 최소 1개 이상 씩 최소 7자리 이상이어야 합니다.")
    private final String password;

    private final String email;

    // Participant(참여자)
    @NotBlank(message = "자기소개를 입력해주세요.")
    private final String selfIntro;

    @NotBlank(message = "알러지 재료를 입력해주세요.")
    private final String allergens;

    @NotNull(message = "모임 정보가 존재하지 않습니다.")
    private final Long meetingId;

    @Builder
    private ParticipantRequestDto(
            String memberName, String birth, String gender,
            String loginId, String password, String email,
            String selfIntro, String allergens, Long meetingId
    ) {
        this.memberName = memberName;
        this.birth = birth;
        this.gender = gender;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.selfIntro = selfIntro;
        this.allergens = allergens;
        this.meetingId = meetingId;
    }

    public Member toMember() {
        return Member.builder()
                .name(getMemberName())
                .birth(DateConverter.convertFromYYYYMMDD(getBirth()))
                .gender(Gender.valueOf(getGender()))
                .loginId(getEmail())
                .password(getPassword())
                .build();
    }

    public Participant toParticipant(final Member member, final Meeting meeting) {
        return Participant.builder()
                .selfIntro(getSelfIntro())
                .allergens(Allergens.getAllergensFromCodes(getAllergens()))
                .member(member)
                .meeting(meeting)
                .build();
    }
}
