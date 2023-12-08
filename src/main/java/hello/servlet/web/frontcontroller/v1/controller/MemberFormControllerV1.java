package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //Controller -> View 이동 시 dispatcher 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //forward : 다른 서블릿이나 jsp로 제어권 이동. 서버 내부에서 재호출 발생
        dispatcher.forward(request, response);
    }
}
