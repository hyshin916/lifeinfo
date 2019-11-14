<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${pageInfo.totalPage > 0}">
	<div data-role="controlgroup" data-type="horizontal" style="font-size: 8pt;" align="center">
		<c:choose>
			<c:when test="${pageInfo.startPage > 1}">
				<a data-role="button" data-theme="a"  href="<c:out value="${pageInfo.url}"/><c:out value="${pageInfo.separator}"/><c:out value="${pageInfo.pageParam}"/>=<c:out value="${pageInfo.previousScalePage}"/><c:out value="${pageInfo.paramString}"/>">이전</a>
			</c:when>
			<c:otherwise>
				<a data-role="button" data-theme="a" href="#">이전</a>
			</c:otherwise>
		</c:choose>
		<c:forEach items="${pageInfo.pages}" var="page" varStatus="status">
	        <c:if test="${pageInfo.currentPage != page}">
	        	<a data-role="button"  href="<c:out value="${pageInfo.url}"/><c:out value="${pageInfo.separator}"/><c:out value="${pageInfo.pageParam}"/>=<c:out value="${page}"/><c:out value="${pageInfo.paramString}"/>">&nbsp;<c:out value="${page}"/>&nbsp;</a>
	        </c:if>
	        <c:if test="${pageInfo.currentPage == page}">
	        	<a data-role="button"  class="ui-btn-active" href="<c:out value="${pageInfo.url}"/><c:out value="${pageInfo.separator}"/><c:out value="${pageInfo.pageParam}"/>=<c:out value="${page}"/><c:out value="${pageInfo.paramString}"/>">&nbsp;<c:out value="${page}"/>&nbsp;</a>
	        </c:if>
	    </c:forEach>
		<c:choose>
			<c:when test="${pageInfo.nextScalePage <= pageInfo.totalPage}">
				<a data-role="button" data-theme="a"  href="<c:out value="${pageInfo.url}"/><c:out value="${pageInfo.separator}"/><c:out value="${pageInfo.pageParam}"/>=<c:out value="${pageInfo.nextScalePage}"/><c:out value="${pageInfo.paramString}"/>">다음</a>
			</c:when>
			<c:otherwise>
				<a data-role="button" data-theme="a" href="#">다음</a>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>