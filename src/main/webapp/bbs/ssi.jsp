<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- ssi.jsp 공통페이지--%>

<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>

<%@ page import="net.utility.*"%>
<%@ page import="net.bbs.*"%>

<jsp:useBean id="dao" class="net.bbs.BbsDAO"></jsp:useBean>
<jsp:useBean id="dto" class="net.bbs.BbsDTO"></jsp:useBean>

<%request.setCharacterEncoding("utf-8");  %>