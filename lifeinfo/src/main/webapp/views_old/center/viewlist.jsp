
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page pageEncoding="utf-8"%>

		<!-- 	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
			 	<div class="main">
					<h2 class="sub-header">크롤링 상품 정보</h2>
					<div class="table-responsive">
						<p>상품상세정보</p>
								<div>
									<ul>
										<c:forEach var="item" items="${viewList}">
											<li style="text-align:left;">${item}</li>
										</c:forEach>
									</ul>
								</div>
						<div class="btn-group" role="group" aria-label="...">
							<button type="button" id="form" class="btn btn-default" onclick="history.back()">목록</button>
						</div>
					</div>
				</div>
	
