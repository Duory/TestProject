Practice app

Требования к приложению:

1. Приложение должно иметь свою иконку, отличную от стандартной.
2. При загрузке должен появляться сплэш-экран (произвольная картинка), без actionbar.
3. В приложении использовать bottom navigation:
- List
- Scaling
- Parsing
- Map
Вкладки должны содержать название и иконку.
4. Приложение должно корректно отображаться в портретной и альбомной ориентации.
5. Проект должен быть в достаточной мере документирован.
6. Приложение должно быть стабильным, то есть не крашиться.

Экраны:

1. List:
- Вывести список редактируемых пунктов: каждый пункт выводить 
как иконку-картинку (двух типов для всех пунктов) + имя пункта + чекбокс 
(если выбран, отображается иконка 1го типа, иначе - 2го типа).
- Добавить кнопку "Add", которая открывает подэкран с формой добавления 
нового пункта (форма с одним полем - Item Name): Внизу две кнопки Done 
(добавить пункт) и Revert (отменить добавление) - по нажатию происходит 
возврат к списку, по нажатию на кнопку Back (на устройстве) выводить 
Alert с предложением сохранить пункт, если поле Item Name было 
отредактированно, если нет, возврат к списку без Alert'a.
- При клике на пункт в списке открывать форму редактирования 
(индентичную форме добавления нового пункта).
- При долгом нажатии на пункт выводить диалог с двумя пунктами Edit 
(открывать форму редактирования, как в предыдущем пункте) и Delete 
(удалить строчку из списка).

Примечание: приложение должно запоминать все вносимые в список изменения 
(добавление новых пунктов и редактирование существующих) - т.е. после 
перезапуска приложения всё должно быть так, как было до закрытия приложения.

2. Scaling:
- На экране должны отображаться две кнопки: 1) выбрать изображение из 
галереи (нативного приложения Gallery); 2) снять изображение на камеру. 
После этого показать эту картинку на новом экране с возможностью 
увеличения и уменьшения через multitouch и через кнопки зума, без 
использования WebView.

3. Parsing:
- Получить от данного URL-а данные: 
http://quotes.zennex.ru/api/v3/bash/quotes?sort=time

- Вывести полученные данные как статичный скроллируемый список, в 
произвольном виде (на свой выбор - главное чтобы было читаемо).
- Во время загрузки показывать троббер (крутилку загрузки).
- Сделать так, чтобы во время вращения троббера, можно было повернуть 
телефон горизонтально, и при этом запрос продолжал идти, а приложение не 
падало.

4. Map:
- Отобразить MapView с указанием текущего местоположения.
- Вывести географические координаты в виде текста на этом же экране.

5. Сделать локализацию приложения на двух языках: русский и английский с 
возможностью переключения языка из приложения (без привязки к языку 
устройства) (для элементов интерфейса и управления приложения, то есть 
элементы списка из пункта 1 переводить не нужно). После перезагрузки 
приложения выбранный язык должен сохраняться.
