<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>квиток</title>
	</head>
	<body style='font-size:20px ; font-weight:100; font-family: Geneva, Times New Roman, Helvetica, sans-serif;'>
		<p>
		РАСЧЕТНЫЙ ЛИСТОК ЗА ${mesyac} 2020
		</p>
		<p>
		${name} 
		</p>
		<p>
		Должность: ${roleName}
		</p>
		<table border="1" width="1000">
			<tr align="center">
			<td colspan="2">Вид</td>
			<td>Период</td>
			<td>Дни</td>
			<td>Часы</td>
			<td>Сумма</td>
			<td colspan="2">Вид</td>
			<td>Период</td>
			<td>Сумма</td>
			</tr>
			<tr>
			<td colspan="6"><b>1.Начислено</b></td>
			<td colspan="4"><b>2.Удержано</b></td>
			</tr>
			<tr>
			<td colspan="2">Премия</td>
			<td>${mesyac} 2020</td>
			<td>0</td>
			<td>0</td>
			<td>${premia}</td>
			<td colspan="2">НДФЛ по ставке 13%</td>
			<td>${mesyac} 2020</td>
			<td>${nalog}</td>
			</tr>
			<tr>
			<td colspan="2">Оклад</td>
			<td>${mesyac} 2020</td>
			<td>${workTime}</td>
			<td>${workTimeHours}</td>
			<td>${zp}</td>
			<td colspan="2"></td>
			<td></td>
			<td></td>
			</tr>
			<tr>
			<td colspan="2">Конпенсация за задержку з.п.,<p>отпуск и т.д.</p></td>
			<td>${mesyac} 2020</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td colspan="2"></td>
			<td></td>
			<td></td>
			</tr>
			<tr>
			<td colspan="2">Всего начислено:</td>
			<td>${mesyac} 2020</td>
			<td>${workTime}</td>
			<td>${workTimeHours}</td>
			<td>${nacislen}</td>
			<td colspan="3">Всего удержано:</td>
			<td>${nalog}</td>
			</tr>
			<tr>
			<td colspan="6"><b>Различные взносы</b></td>
			<td colspan="2"><b>Сумма к выплате</b></td>
			<td>${mesyac} 2020</td>
			<td>${finalZp}</td>
			</tr>
			<tr>
			<td colspan="5">Страховые взносы в ПФР(22%)</td>
			<td>${nalog1}</td>
			</tr>
			<tr>
			<td colspan="5">Мед страхование(5,1%)</td>
			<td>${nalog2}</td>
			</tr>
			<tr>
			<td colspan="5">Фонд соц. страхования(2,9%)</td>
			<td>${nalog3}</td>
			</tr>
			<tr>
			<td colspan="5">ФСС(0,2%)</td>
			<td>${nalog4}</td>
			</tr>
		</table>
	</body>
</html>