<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>[Bài tập] Ứng dụng Calculator
    </title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculatorServlet">
    <p>First Operand:
      <input type="text" name="first_operand"></p>
    <p>Operator:
      <select name="operator">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select>
    </p>
    <p>Second Operand
      <input type="text" name="second_operand"></p>
    <input type="submit" value="Calculate">
  </form>

  </body>
</html>
