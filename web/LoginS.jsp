<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <style>
    #bt {
      background-color: #3f3f3f;
      border: none;
      color: black;
      padding: 10px 20px;
      text-align: center;
      font-size: 15px;
      cursor: pointer;
      border-radius: 8px;
      position: absolute;
      bottom: 0px;
      left: 150px;
      color: #d6d6d6;
    }
    #user, #pw{
      width: 60%;
      padding: 10px 20px;
      font-size: 18px;
      background-color: #8c8c8c;
      position: relative;
      left: 58px;
    }
    #szoveg1{
      position: relative;
      top: -8px;
      left: 5px;
    }
    #szoveg2{
      position: relative;
      top: -8px;
      left: 5px;
    }
    .container {
      position: absolute;
      top: 50px;
      left: 35%;
      border: 1px solid black;
      font-size: 20px;
      background-color: #e8e8e8;
    }
    ::placeholder {
      color: #424242;
    }

  </style>
</head>
<body style="background-color: #555555">
<form action="LoginServlet" method="POST">
  <div class="container">
    <br>
    <label><b id="szoveg1">Felhasználónév:</b></label>
    <input id="user" type="text" placeholder="Írja be a felhasználónevét !" name="felh_nev" required>
    <br><br>
    <label><b id="szoveg2">Jelszó:</b></label>
    <br>
    <input id="pw" type="password" placeholder="Írja be a jelszavát !" name="jelszo" required>
    <br><br>
    <button id="bt" type="submit">Belépés</button>
    <br>

  </div>
</form>


</body>
</html>
