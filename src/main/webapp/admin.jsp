<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dig's Blog</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

<style type="text/css">

body {
	min-height: 75rem;
	padding-top: 4.5rem;
}
</style>


</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Dig Blog</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link " aria-current="page"
						href="/blog">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/blog/posts">Admin</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/blog/novopost.jsp"><i class="bi bi-plus-circle"></i>
							NEW POST</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">


		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Text</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${posts}">
						<tr>
							<th>${item.id}</th>
							<td>${item.title}</td>
							<td>${item.text}</td>
							<td><a href="/blog/posts/update?id=${item.id}"><i
									class="bi bi-pencil-square"></i></a> | <a
								href="/blog/posts/delete?id=${item.id}"><i
									class="bi bi-trash"></i></a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>