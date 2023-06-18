package woowaapplication.individual.moim.meeting;

import lombok.Builder;
import lombok.NoArgsConstructor;
import woowaapplication.individual.moim.member.domain.Member;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Meeting {

    @Id
    @GeneratedValue
    @Column(name = "meeting_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 65535)
    private String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Meeting(
            String name, String address,
            String description, Member member
    ) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.member = member;
    }
}
