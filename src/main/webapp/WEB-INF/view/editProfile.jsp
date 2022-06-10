
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<p> Profile picture: </p>



<form action="/edit-profile" method="post" enctype="multipart/form-data">
  <input type="file" id="filename" name="filename">
  <input type="submit" value="Confirm choice">
</form>

<img alt="img" src="data:image/jpeg;base64,${uploadedFile}"/>
<br>
