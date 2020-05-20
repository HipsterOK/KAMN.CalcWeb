<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<form class="form-horizontal" action="calcManager" method="POST">
<fieldset>
<!-- Form Name -->
<legend>Калькулятор</legend>
<p> <label class="w3-text-teal"><b>Добро пожаловать, ${name} ! </b></label>

<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Выберите месяц</label>
  <div class="col-md-4">
    <select id="selectMonth" name="selectMonth" class="form-control">
      <option value="0">Январь</option>
      <option value="1">Февраль</option>
      <option value="2">Март</option>
      <option value="3">Апрель</option>
      <option value="4">Май</option>
      <option value="5">Июнь</option>
      <option value="6">Июль</option>
      <option value="7">Август</option>
      <option value="8">Сентябрь</option>
      <option value="9">Октябрь</option>
      <option value="10">Ноябрь</option>
      <option value="11">Декабрь</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Сотрудник</label>
  <div class="col-md-4">
    <select id="selectUser" name="selectUser" class="form-control">
       <c:forEach items="${userList}" var="userList" varStatus="loop">
    <option value="${loop.index}">
        ${userList.name}
    </option>
    </c:forEach>
    </select>
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Рассчитать</button>
  </div>
</div>

</fieldset>
</form>
</html>