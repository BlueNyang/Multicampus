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
        <div class="content">
          <pre class="stage">${hangmanGame.hangmanVisual}</pre>
          <c:choose>
            <c:when test="${hangmanGame.hangmanGameStatus == statusList.ONGOING}">
              <div class="current-word">
                <p class="current-cat">
                  Category: ${secretWord.category}
                </p>
                <div class="current-container">
                    ${hangmanGame.currentWordState}
                </div>
                <div class="input-section">
                  <div class="input-container">
                    <form method="POST" action="guess">
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
        <c:if test="${result == resultList.INVALID_INPUT}">
          <div class="alert alert-warning">
            Invalid input! Please enter a 5-digit number with all different digits.
          </div>
        </c:if>
        <div class="messagebox">
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
    <script src="<c:url value="/resources/js/hangmanApp.js"/>"></script>
  </body>
</html>
