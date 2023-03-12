package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // 외부에서 넣어주겠금, 바꾸어 준다?? >> 테스트할때, 서로 다른 인스턴스를 가질 수 있어서, 이렇게 하는 방법을 DI(dependency injection)
    //@Autowired //아 너는 memberRepository가 필요하구나 하고, 스프링이 memberRepository를 넣어준다. 서로 연결해 준다. DI다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        //원래 코드
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); // 이 부분을 validateDuplicateMember 메소드처럼 코드를 만들어주고, 메서드로 따로 뺴서 이름 validateDuplicateMember로 만들어주기
        validateDuplicateMember(member); //중복회원검증

        memberRepository.save(member);
        return member.getId();
    }

    //회원가입시 Name으로 중복확인하는 메서드
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m-> {
                                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                                });
    }
    
    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    

}
