
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

			<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
				<h2 class="sub-header">&nbsp;지역축제</h2>
				<div class="table-responsive">
					<form name="my_form">
					<table class="table table-striped">
						<thead>
						</thead>
						<tbody>
							<c:forEach var="item" items="${festivalList}" varStatus="status">
								<tr>
								<td><a href="${item.hmpg}">[ ${item.sigun} ]&nbsp;${item.title}</a></td>
								</tr>
							</c:forEach>
						
						</tbody>
					</table>
					</form>
				</div>
	