<%@ page import="kr.bluenyang.practice.webgame.domain.numbb.NumberBaseballGame"%>
<%@ page import="kr.bluenyang.practice.webgame.domain.numbb.NumberBaseballResult"%>
<%@ page import="java.util.List"%>
<%@ page import="kr.bluenyang.practice.webgame.domain.numbb.NumberBaseballStatus"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 01:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
  NumberBaseballGame game;
  NumberBaseballStatus result;
%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WebGame::NumberBaseball</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/game.css"/>
    <link rel="stylesheet" type="text/css" href="../css/numbb.css"/>
  </head>
  <body>
    <%
      game = (NumberBaseballGame) session.getAttribute("game");
      result = (NumberBaseballStatus) session.getAttribute("result");
    %>
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
              <form method="POST" action="guess">
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
            <p class="attempts">tries: <%=game.getAttempts()%>
            </p>
          </div>
        </div>
        <%
          if (result != null) {
            if (result == NumberBaseballStatus.INVALID_INPUT) {
        %>
        <div class="alert alert-warning">
          Invalid input! Please enter a 5-digit number with all different digits.
        </div>
        <%
        } else if (result == NumberBaseballStatus.INVALID_LENGTH) {
        %>
        <div class="alert alert-warning">
          Invalid input! Please enter a 5-digit number.
        </div>
        <%
        } else if (result == NumberBaseballStatus.SOLVED) {
        %>
        <div class="alert alert-success">
          Congratulations! You've guessed the correct number: <%=game.getSecretNumber()%>
        </div>
        <%
            }
          }
        %>
        <div class="result-container">
          <div class="result-area">
            <h3 class="result-title">Result</h3>
            <div class="result-list">
              <%
                if (game.getAttempts() != 0) {
                  int len = game.getAttempts();
                  List<NumberBaseballResult> history = game.getResults();
                  for (int i = len - 1; i >= 0; i--) {
                    NumberBaseballResult r = history.get(i);
                    String res = "";
                    if (r.strikes() == 0 && r.balls() == 0) {
                      res = "out";
                    } else {
                      if (r.strikes() > 0) {
                        res += r.strikes() + "S ";
                      }
                      if (r.balls() > 0) {
                        res += r.balls() + "B";
                      }
                    }
              %>
              <div class="result-item">
                <div class="result-input">
                  <span class="index badge"><%=i%></span>
                  <span class="guess-number"><%=r.input()%></span>
                </div>
                <span class="result badge"><%=res%></span>
              </div>
              <%
                  }
                }
              %>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="../js/baseballApp.js"></script>
  </body>
</html>
