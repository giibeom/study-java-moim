package woowaapplication.individual.moim.member.application.command;

import woowaapplication.individual.moim.meeting.domain.Meeting;
import woowaapplication.individual.moim.member.domain.Member;
import woowaapplication.individual.moim.member.domain.MemberRole;

public interface HostMemberRequest {

    String getMemberName();

    String getBirth();

    String getGender();

    MemberRole getRole();

    String getLoginId();

    String getPassword();

    String getEmail();

    String getMeetingName();

    String getAddress();

    String getDescription();

    Member toMember();

    Meeting toMeeting(Member member);
}