package woowaapplication.individual.moim.member.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woowaapplication.individual.moim.member.application.MemberService;
import woowaapplication.individual.moim.member.presentation.dto.request.HostMemberRequestDto;
import woowaapplication.individual.moim.member.presentation.dto.request.ParticipantRequestDto;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/members")
class MemberController {

    private final MemberService memberService;

    MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/host")
    ResponseEntity<Void> createHost(@RequestBody @Valid final HostMemberRequestDto hostMemberRequestDto) {
        Long memberId = memberService.createHostMember(hostMemberRequestDto);

        return ResponseEntity.created(URI.create("/api/v1/members/host/" + memberId)).build();
    }

    @PostMapping("/participant")
    ResponseEntity<Void> createParticipant(@RequestBody @Valid final ParticipantRequestDto participantRequestDto) {
        Long memberId = memberService.createParticipantMember(participantRequestDto);

        return ResponseEntity.created(URI.create("/api/v1/members/host/" + memberId)).build();
    }
}
