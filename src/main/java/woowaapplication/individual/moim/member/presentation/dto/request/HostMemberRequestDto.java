package woowaapplication.individual.moim.member.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import woowaapplication.individual.moim.common.utils.DateConverter;
import woowaapplication.individual.moim.meeting.domain.Meeting;
import woowaapplication.individual.moim.member.application.command.HostMemberRequest;
import woowaapplication.individual.moim.member.domain.Gender;
import woowaapplication.individual.moim.member.domain.Member;
import woowaapplication.individual.moim.member.domain.MemberRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static woowaapplication.individual.moim.member.domain.MemberRole.HOST;

@Getter
public class HostMemberRequestDto implements HostMemberRequest {
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

    // Meeting(모임)
    @NotBlank(message = "모임 이름을 입력해주세요.")
    private final String meetingName;

    @NotBlank(message = "모임 주소를 입력해주세요.")
    private final String address;

    private final String description;

    @Builder
    private HostMemberRequestDto(
            String memberName, String birth, String gender,
            String loginId, String password, String email,
            String meetingName, String address, String description
    ) {
        this.memberName = memberName;
        this.birth = birth;
        this.gender = gender;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.meetingName = meetingName;
        this.address = address;
        this.description = description;
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

    public Meeting toMeeting(final Member member) {
        return Meeting.builder()
                .name(getMeetingName())
                .address(getAddress())
                .description(getDescription())
                .member(member)
                .build();
    }
}
