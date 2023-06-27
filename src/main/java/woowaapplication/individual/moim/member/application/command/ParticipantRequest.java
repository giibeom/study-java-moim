package woowaapplication.individual.moim.member.application.command;

import woowaapplication.individual.moim.meeting.domain.Meeting;
import woowaapplication.individual.moim.participant.domain.Participant;
import woowaapplication.individual.moim.member.domain.Member;
import woowaapplication.individual.moim.member.domain.MemberRole;

public interface ParticipantRequest {

    String getMemberName();

    String getBirth();

    String getGender();

    MemberRole getRole();

    String getLoginId();

    String getPassword();

    String getEmail();

    String getSelfIntro();

    String getAllergens();

    Long getMeetingId();

    Member toMember();

    Participant toParticipant(final Member member, final Meeting meeting);
}
