<%@ page import="kr.bluenyang.practice.webgame.domain.wordgen.WordGenerator"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Multicampus - WebGame</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/style.css"/>
  </head>
  <body>
    <div id="app">
      <div class="container">
        <div class="title">
          <div class="logo">
            <div class="icon">
              <%@ include file="assets/controller.svg"%>
            </div>
            <h1>멀티캠퍼스 WebGame</h1>
            <div class="icon">
              <%@ include file="assets/controller-outline.svg"%>
            </div>
          </div>
          <p>JAVA 풀스택 개발자 아카데미 6회차_안규태</p>
        </div>
        <div class="content">
          <button id="hangmanBtn" class="hangman-btn btn">
            Play Hangman
          </button>
          <button id="numBaseballBtn" class="rps-btn btn">
            Play Number Baseball
          </button>
        </div>
      </div>
    </div>
    <script src="js/app.js"></script>
  </body>
</html>