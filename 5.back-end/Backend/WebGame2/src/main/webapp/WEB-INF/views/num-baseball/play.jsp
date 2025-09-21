<%--@elvariable id="attempts" type="java.util.List"--%>
<%--@elvariable id="secret" type="java.util.List"--%>
<%--@elvariable id="statusList" type="java.util.Map"--%>
<%--@elvariable id="attemptCount" type="java.lang.Integer"--%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 01:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="status" value="${sessionScope.status}"/>
<c:if test="${not empty status}">
  <c:remove var="status" scope="session"/>
</c:if>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WebGame::NumberBaseball</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/game.css"/> "/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/numbb.css"/>"/>
  </head>
  <body>
    <%--
      game = (NumberBaseballGame) session.getAttribute("game");
      result = (NumberBaseballStatus) session.getAttribute("result");
    --%>
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
          <div class="title-area">
            <div class="title">Guessing different 5-digit number</div>
            <p class="subtitle">When the same number is in the same position, it's a strike.</p>
            <p class="subtitle">When the same number is in a different position, it's a ball.</p>
          </div>
          <div class="input-section">
            <div class="input-container">
              <form method="POST" action="${pageContext.request.contextPath}/num-baseball/guess">
                <label for="guessInput"></label>
                <input
                   id="guessInput"
                   class="guess-input"
                   name="guess"
                   type="text"
                   maxlength="5"
                   placeholder="12345"
                   autofocus
                />
                <input type="submit" id="guessBtn" class="guess-btn btn" value="Guess"/>
              </form>
            </div>
            <p class="attempts">tries: ${attempts.size()}
            </p>
          </div>
        </div>
        <c:choose>
          <c:when test="${status == statusList.INVALID_INPUT}">
            <div class="alert alert-warning">
              Invalid input! Please enter a 5-digit number with all different digits.
            </div>
          </c:when>
          <c:when test="${status == statusList.INVALID_LENGTH}">
            <div class="alert alert-warning">
              Invalid input! Please enter a 5-digit number.
            </div>
          </c:when>
          <c:when test="${status == statusList.SOLVED}">
            <div class="alert alert-success">
              Congratulations! You've guessed the correct number: ${secret}
            </div>
          </c:when>
          <c:otherwise>
            <div></div>
          </c:otherwise>
        </c:choose>
        <div class="result-container">
          <div class="result-area">
            <h3 class="result-title">Result</h3>
            <div class="result-list">
              <c:if test="${not empty attempts}">
                <c:forEach var="attempt" items="${attempts}" varStatus="status">
                  <div class="result-item">
                    <div class="result-input">
                      <span class="index badge">${attemptCount - status.index}</span>
                      <span class="guess-number">
                          ${attempt.input}
                      </span>
                    </div>
                    <c:choose>
                      <c:when test="${attempt.strikes == 0 && attempt.balls == 0}">
                        <span class="result badge">out</span>
                      </c:when>
                      <c:otherwise>
                          <span class="result badge">
                            <c:if test="${attempt.strikes > 0}">
                              ${attempt.strikes}S
                            </c:if>
                            <c:if test="${attempt.balls > 0}">
                              ${attempt.balls}B
                            </c:if>
                          </span>
                      </c:otherwise>
                    </c:choose>
                  </div>
                </c:forEach>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="<c:url value="/resources/js/baseballApp.js"/>"></script>
  </body>
</html>
