package com.bbs.starter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bbs.starter.dto.Member;
import com.bbs.starter.service.MemberService;

@Component("beforeActionInterceptor")
public class BeforeActionInterceptor implements HandlerInterceptor {
	@Autowired
	MemberService memberService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isLogined = false;
		long loginedMemberId = 0;
		Member loginedMember = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (long) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getOne(loginedMemberId);
		}
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMember", loginedMember);

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
