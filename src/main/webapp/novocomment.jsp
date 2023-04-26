<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UCSal Blog</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
<style type="text/css">
/* Show it is fixed to the top */
body {
	min-height: 75rem;
	padding-top: 4.5rem;
}
</style>


</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">UCSal Blog</a>
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
							NOVO POST</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<form action="/blog/comment/create" method="post">
			<input type="hidden" name="id" value="${post.id}">
			
			<div class="form-floating  mb-3">
				<textarea class="form-control" required="required" placeholder="Text" id="textId" style="height: 100px" name="text"></textarea>
				<label for="textId">Text</label>
			</div>			
			<div class="d-grid col-6 mx-auto">
				<button type="submit" class="btn btn-primary">Salvar</button>
			</div>
		</form>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>