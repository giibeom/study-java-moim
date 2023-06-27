package woowaapplication.individual.moim.participant.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import woowaapplication.individual.moim.meeting.domain.Meeting;
import woowaapplication.individual.moim.member.domain.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Participant {

    @Id
    @GeneratedValue
    @Column(name = "participant_id")
    private Long id;

    @Column(length = 100)
    private String selfIntro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ElementCollection
    @CollectionTable(name = "ALLERGENS",
            joinColumns = @JoinColumn(name = "participant_id"))
    @Column(name = "name")
    private List<Allergens> allergens = new ArrayList<>();

    @Builder
    private Participant(
            String selfIntro, Member member,
            Meeting meeting, List<Allergens> allergens
    ) {
        this.selfIntro = selfIntro;
        this.member = member;
        this.meeting = meeting;
        this.allergens = allergens;
    }
}
