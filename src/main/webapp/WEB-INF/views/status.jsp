<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Printizen CSV Tool | CSV File</title>

</head>
<body>
	<h1>Field Mapping</h1>
	<%-- <form method="POST" action="/template" enctype="multipart/form-data"> --%>
	<form:form modelAttribute="templatecolumns" method="POST"
		action="/template">
		<div>
			<div>
				<p>
					<!-- Batch ID: <input id="batchid" name="batchid" type="text" />  -->
					Batch Name: <input id="batchname" name="batchname" type="text"
						required /> Batch size: <input id="batchsize" name="batchsize"
						type="number" />
				</p>

				<select id="csvheader1" name="csvheader1" multiple
					size=${ dropdownsize+1}>
					<option value="none" selected>--Select--</option>
					<c:forEach var="line" items="${csvheader}">
						<option><c:out value="${line}" /></option>
					</c:forEach>
				</select> <label> ${sellerSKUID} </label> <input type="text"
					name="sellerSKUID" /> <br /> <br /> <select id="csvheader2"
					name="csvheader2" multiple size=${ dropdownsize+1}>
					<option value="none" selected>--Select--</option>
					<c:forEach var="line" items="${csvheader}">
						<option><c:out value="${line}" /></option>
					</c:forEach>

				</select> <label>${Subcategory}</label> <input type="text"
					name="Sub-category" /> <br /> <br /> <select id="csvheader3"
					name="csvheader3" multiple size=${ dropdownsize+1}>
					<option value="none" selected>--Select--</option>
					<c:forEach var="line" items="${csvheader}">
						<option><c:out value="${line}" /></option>
					</c:forEach>

				</select> <label>${Brand}</label> <input type="text" name="Brand" /> <br />
				<br /> <select id="csvheader4" name="csvheader4" multiple
					size=${ dropdownsize+1}>
					<option value="none" selected>--Select--</option>
					<c:forEach var="line" items="${csvheader}">
						<option><c:out value="${line}" /></option>
					</c:forEach>

				</select> <label>${ModelName}</label> <input type="text" name="ModelName" />

				<input type="hidden" name="csvfilename" value="${csvfile}">
				<br /> <br /> <input type="submit" value="Submit" />
			</div>
		</div>
	</form:form>
	<%-- </form> --%>
</body>
</html>