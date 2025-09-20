<%--@elvariable id="hangmanGame" type="kr.bluenyang.webgame.dto.hangman.HangmanDTO"--%>
<%--@elvariable id="secretWord" type="kr.bluenyang.webgame.domain.hangman.SecretWord"--%>
<%--@elvariable id="result" type="kr.bluenyang.webgame.dto.hangman.HangmanGameResult"--%>
<%--@elvariable id="statusList" type="java.uril.Map"--%>
<%--@elvariable id="resultList" type="java.uril.Map"--%>
<%--
  Created by IntelliJ IDEA.
  User: BlueNyang
  Date: 11/09/2025
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WebGame::Hangman</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/common.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/game.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/hangman.css'/>"/>
  </head>
  <body>
    <div id="app">
      <div class="container">
        <%--  Navigation Bar  --%>
        <div class="navbar">
          <button id="prevBtn" class="prev btn">
            &lt; Back
          </button>
          <h1>
            Hangman Game
          </h1>
          <button id="resetBtn" class="reset btn">
            New Game
          </button>
        </div>
        <%--  Game Content  --%>
        <div class="content">
          <%--행맨 게임 진행 화면--%>
          <pre class="stage">${hangmanGame.hangmanVisual}</pre>
          <c:choose>
            <%--  게임 진행 중  --%>
            <c:when test="${hangmanGame.hangmanGameStatus == statusList.ONGOING}">
              <div class="current-word">
                <p class="current-cat">
                    <%--  단어의 카테고리 표시  --%>
                  Category: ${secretWord.category}
                </p>
                <div class="current-container">
                    <%--  현재 단어 상태 표시  --%>
                    ${hangmanGame.currentWordState}
                </div>
                <div class="input-section">
                  <div class="input-container">
                      <%--  사용자 입력 폼  --%>
                    <form method="POST" action="${pageContext.request.contextPath}/hangman/guess">
                      <label for="guessInput"></label>
                      <input
                         id="guessInput"
                         class="guess-input"
                         name="guessInput"
                         type="text"
                         maxlength="1"
                         placeholder="Enter a letter"
                         autofocus
                      />
                      <input type="submit" id="guessBtn" class="guess-btn btn" value="Guess"/>
                    </form>
                  </div>
                </div>
              </div>
            </c:when>
            <%--  게임 종료: 승리  --%>
            <c:when test="${hangmanGame.hangmanGameStatus == statusList.WON}">
              <div class="result-container">
                <h2>Congratulations! You've won!</h2>
                <p>The word was:
                  <strong>
                      ${hangmanGame.currentWordState}
                  </strong>
                </p>
              </div>
            </c:when>
            <%--  게임 종료: 패배  --%>
            <c:when test="${hangmanGame.hangmanGameStatus == statusList.LOST}">
              <div class="result-container">
                <h2>Game Over! You've lost!</h2>
                <p>The word was:
                  <strong>
                      ${hangmanGame.currentWordState}
                  </strong>
                </p>
              </div>
            </c:when>
          </c:choose>
        </div>
        <%--  에러 메시지 박스  --%>
        <c:if test="${result == resultList.INVALID_INPUT}">
          <%--  잘못된 입력이 있는 경우 경고 메시지 표시  --%>
          <div class="alert alert-warning">
            Invalid input! Please enter a 5-digit number with all different digits.
          </div>
        </c:if>
        <%--  상태 메시지 박스  --%>
        <div class="messagebox">
          <%--  남은 기회 및 사용된 문자 표시  --%>
          <div class="message-content">
            <div class="message-container">
              <span class="message">Wrong Guess: </span>
              <div class="badge">
                ${hangmanGame.chancesLeft}/7
              </div>
            </div>
            <span>Used Letters:</span>
            <div class="used-list">
              <c:forEach var="c" items="${hangmanGame.usedLetters}">
                <div class="badge">
                    ${c}
                </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%--  JavaScript 파일 포함  --%>
    <script src="<c:url value="/resources/js/hangmanApp.js"/>"></script>
  </body>
</html>
