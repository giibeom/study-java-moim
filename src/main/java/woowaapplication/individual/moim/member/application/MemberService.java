package woowaapplication.individual.moim.member.application;

import org.springframework.stereotype.Service;
import woowaapplication.individual.moim.member.application.command.HostMemberRequest;
import woowaapplication.individual.moim.member.application.command.ParticipantRequest;
import woowaapplication.individual.moim.meeting.domain.MeetingRepository;
import woowaapplication.individual.moim.member.domain.Member;
import woowaapplication.individual.moim.member.domain.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MeetingRepository meetingRepository;

    public Long createHostMember(HostMemberRequest requestHostMember) {
        Member member = requestHostMember.toMember();
        memberRepository.save(member);
        meetingRepository.save(requestHostMember.toMeeting(member));
        return null;
    }

    public Long createParticipantMember(ParticipantRequest participantRequest) {
        return null;
    }
}
