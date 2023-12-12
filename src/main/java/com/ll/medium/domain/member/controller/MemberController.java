package com.ll.medium.domain.member.controller;

import com.ll.medium.domain.member.JoinForm;
import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping ("/join")
    public String join(){
        return "domain/member/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm/*, BindingResult bindingResult*/){
        /*if(bindingResult.hasErrors()){
            return "domain/member/join";
        }
        if (!joinForm.getPassword().equals(joinForm.getPasswordCheck())){
            bindingResult.rejectValue("passwordCheck", "passwordIncorrect", "비밀번호 확인이 일치하지 않습니다.");
            return "domain/member/join";
        }*/

        Member member = memberService.join(joinForm.getUsername(), joinForm.getPassword());
        Integer id = member.getId();

        return "redirect:/?msg=No %d member joined.".formatted(id);
    }
}
