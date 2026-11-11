# Проект по автоматизации тестирования UI части стартовой страницы онлайн справочника D&D TTG Club

  > Тестируемый ресурс - https://5e14.ttg.club/

## Стек технологий

<p align="center">
<a href="https://www.java.com/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" height="50"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" height="50"/></a>
<a href="https://junit.org/junit5/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="50" height="50"/></a>
<a href="https://qameta.io/allure-report/"><img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="50" height="50"/></a>
<a href="https://www.jenkins.io/"><img src="https://www.jenkins.io/images/logos/jenkins/jenkins.svg" width="50" height="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jira/jira-original.svg" width="50" height="50"/></a>
<a href="https://telegram.org/"><img src="https://i.pinimg.com/originals/4a/4d/ee/4a4dee00b008fdf71e32f694ba17453f.jpg?nii=t" width="50" height="50"/></a>
</p>

## Список проверок

- Проверка простого сценария поиска с главной страницы
- Проверка отображения навигационного меню
- Проверка перехода на страницу поиска
- Проверка отображения списка закладок
- Проверка отображения окна для сообщения о баге
- Проверка переключения на тёмную цветовую тему
- Проверка сценария перехода на страницу класса с главной страницы
- Проверка открытия модального окна с видеороликом на главной странице
- Проверка отработки калькулятора формул
- Проверка перехода на страницу с Токенатором

## Запуск тестов
### Из терминала
```bash
clean test \
-DbaseUrl=$BASE_URL \
-DremoteBrowserUrl=$SELENOID_URL \
-Dbrowser=$BROWSER\
-DbrowserVersion=$BROWSER_VERSION \
-Dheadless=$HEADLESS \
-DbrowserSize=$BROWSER_SIZE
```
Используемые параметры:
- BASE_URL (url адрес тестируемой страницы);
- SELENOID_URL (url адрес удалённой фермы браузеров);
- BROWSER (браузер);
- BROWSER_VERSION (версия браузера);
- HEADLESS (параметр для запуска UI тестов без открытия браузера);
- BROWSER_SIZE (параметр расширения браузера)

 ### Из Jemkins
 [Ссылка на задачу Jenkins](https://jenkins.autotests.cloud/view/java_students/job/quastrado_TTGClub_job/)
<p align="center">
<img title="Job" src="images/job.png">
</p>

- Выбрать браузер;
- Выбрать разрешение браузера;
- Запустить сборку

## Allure Report
[Ссылка на отчёт в Allure](https://jenkins.autotests.cloud/view/java_students/job/quastrado_TTGClub_job/allure/)
### Дашборд
<p align="center">
<img title="Overview" src="images/allure_report_overview.png">
</p>

### Пройденные тесты
<p align="center">
<img title="Suites" src="images/allure_report_suites.png">
</p>

### Видео прохождения теста
<p align="center">
<img title="Video" src="video/5f08f693eff7119c3ce9a1901c5ca14b.mp4">
</p>

### Метрики
<p align="center">
<img title="Graphs" src="images/allure_report_graphs.png">
</p>

## Allure TestOps
[Ссылка на Allure TestOps](https://allure.autotests.cloud/project/5250/dashboards)
### Дашборд
<p align="center">
<img title="Dashboard" src="images/dashboard.png">
</p>

### Автоматизированные и ручные тест-кейсы
<p align="center">
<img title="Testcases" src="images/testcases.png">
</p>

## Telegram уведомления
<p align="center">
<img title="Telegram" src="images/telegram.jpg" width="600">
</p>
