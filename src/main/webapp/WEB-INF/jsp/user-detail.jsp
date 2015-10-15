<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<h1>${user.name}</h1>
<c:forEach items="${user.blogs}" var="blog">
	<h1>${blog.name}</h1>
	<p>
		<a href='<spring:url value="/blog/remove/${blog.id}.html"/>'
			class="btn btn-danger">remove post</a> ${blog.url}
	</p>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</c:forEach>

