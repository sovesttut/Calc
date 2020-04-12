1. package main.java;
2. 
3. /* Подключаем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
4. import java.awt.BorderLayout;
5. import java.awt.Color;
6. import java.awt.Dimension;
7. import java.awt.event.ActionEvent;
8. import java.awt.event.ActionListener;
9. import javax.swing.BoxLayout;
10. import javax.swing.JButton;
11. import javax.swing.JComponent;
12. import javax.swing.JFrame;
13. import javax.swing.JLabel;
14. import javax.swing.JOptionPane;
15. import javax.swing.JPanel;
16. import javax.swing.JTextField;
17. import javax.swing.SwingUtilities;
18. import javax.swing.border.EtchedBorder;
19. 
20. /* Создаем главный класс программы, реализующий интерфейс ActionListener,
21. который отвечает за обработку события нажатия на кнопку.*/
22. public class Calculator implements ActionListener{
23. 	/* Создаем переменную id типа boolean, в которой хранится состояние авторизации
24. 	(если авторизация не пройдена, то значение переменной равно false,
25. 	в противном случае true).*/
26. 	private boolean id = false;
27. 	
28. 	/* Создаем метод, который изменяет значение
29.     переменной id на значение, которое было
30. 	передано в параметрах метода.*/	
31. 	public void setStateId(boolean id) {
32. 		this.id = id;
33. 	}
34. 	
35. 	/* Создаем метод, который возвращает значение
36. 	переменной id при вызове.*/
37. 	public boolean getStateId() {
38. 		return id;
39. 	}
40. 	
41. 	/* Создаем объект главного окна с помощью ключевого слова new */
42.     JFrame frame = new JFrame("Расчет количества символов в тексте");
43. 	/* Создаем объект панели с метками */
44.     JPanel panelLeft = new JPanel();
45. 	/* Создаем объект панели с текстовыми полями */
46.     JPanel panelRight = new JPanel();
47. 	/* Создаем объект панели с кнопками */
48.     JPanel panelBottom = new JPanel();
49. 	/* Создаем массив текстовых полей */
50.     public JTextField[] fields = new JTextField[2];
51. 
52.     /* Добавляем конструктор класса */
53.     public Calculator() {
54.     	/* Для того, чтобы изменить цвет фона.
55.     	panelLeft.setBackground(Color.red);
56.     	panelRight.setBackground(Color.red);
57.     	panelBottom.setBackground(Color.red);
58.     	*/
59.         /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
60.         panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
61.         /* Устанавливаем размер панели с метками 250 на 300 пикселей */
62.         panelLeft.setPreferredSize(new Dimension(250, 300));
63.         /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
64.         panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
65.         /* Устанавливаем размер панели с текстовыми полями 370 на 300 пикселей */
66.         panelRight.setPreferredSize(new Dimension(370,300));
67.         /* Добавляем метки к текстовым полям через метод addLabel */
68.         addLabel(panelLeft, "Текст:", Color.BLACK);
69.         addLabel(panelLeft, "Количество символов в тексте:", Color.BLACK);
70.         /* Добавляем текстовые поля через цикл и записываем их в массив */
71.         for(int i = 0; i < fields.length; i++){
72.             if(fields.length >= 0){
73.                 /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
74.                 fields[i] = addTextField(panelRight);}
75.         }
76. 
77.         /* Добавляем кнопку расчета количества символов */
78.         JButton calc = addButton(panelBottom, "Расчет символов");
79.         /* Добавляем слушатель на событие нажатия кнопки расчета символов */
80.         calc.addActionListener(this);
81. 		/* Добавляем кнопку сброса */
82.         JButton reset = addButton(panelBottom, "Сброс");
83.         /* Добавляем слушатель на событие нажатия кнопки сброса */
84.         reset.addActionListener(this);
85. 		/* Добавляем кнопку авторизации */
86.         JButton authorization = addButton(panelBottom, "Авторизация");
87.         /* Добавляем слушатель на событие нажатия кнопки авторизации*/
88.         authorization.addActionListener(this);
89.         /* Добавляем кнопку расчета количества точек и запятых */
90.         JButton punMarks = addButton(panelBottom, "Расчет точек и запятых");
91.         /* Добавляем слушатель на событие нажатия кнопки расчета количества точек и запятых */
92.         punMarks.addActionListener(this);
93.         /* Делаем главное окно видимым */
94.         frame.setVisible(true);
95.         /* Устанавливаем действие при нажатии на крестик - завершение приложения */
96.         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
97.         /* Устанавливаем начальное положение главного окна относительно центра экрана (по центру) */
98.         frame.setLocationRelativeTo(null);
99.         /* Устанавливаем размер главного окна(600 на 200) */
100.         frame.setSize(600,200);
101.         /* Добавляем панель с метками на главное окно */
102.         frame.add(panelLeft, BorderLayout.WEST);
103. 		/* Добавляем панель с текстовыми полями на главное окно */
104.         frame.add(panelRight, BorderLayout.EAST);
105. 		/* Добавляем панель с кнопками на главное окно */
106.         frame.add(panelBottom, BorderLayout.SOUTH);
107. 		/* Запрещаем изменение размеров главного окна */
108.         frame.setResizable(false);
109.     }
110. 
111.     /* Метод добавления текстовых меток */
112.     public void addLabel(JComponent container, String name, Color color){
113.         /* Создаем объект текстовой метки */
114.         JLabel label = new JLabel(name);
115.         /* Устанавливаем максимально допустимый размер метки */
116.         label.setMaximumSize(new Dimension(200,20));
117.         /* Устанавливаем цвета текста метки */
118.         label.setForeground(color);
119.         /* Для того, чтобы изменить цвет рамки текстового поля
120.         if (name == "") {label.setBackground(Color.red);}
121. 		*/
122.         /* Устанавливаем выравнивание метки по правому краю */
123.         label.setHorizontalAlignment(JLabel.RIGHT);
124.         /* Добавляем рамку вокруг метки */
125.         label.setBorder(new EtchedBorder());
126.         /* Добавляем метку на панель */
127.         container.add(label);
128.     }
129. 
130.     /* Метод добавления текстовых полей */
131.     public JTextField addTextField(JComponent container){
132.         /* Создаем объект текстового поля */
133.         JTextField field = new JTextField();
134.         /* Устанавливаем максимально допустимый размер поля */
135.         field.setMaximumSize(new Dimension(350,20));
136.         /* Добавляем поле на панель */
137.         container.add(field);
138.         /* Возвращаем ссылку на текстовое поле */
139.         return field;
140.     }
141. 
142.     /* Метод добавления кнопок */
143.     public JButton addButton(JComponent container, String name){
144.         /* Создаем объект кнопки */
145.         JButton button = new JButton(name);
146.         /* Для того, чтобы изменить цвет кнопки
147.         if (name == "") {button.setBackground(Color.red);}
148.         */
149.         /* Устанавливаем максимально допустимый размер кнопки */
150.         button.setMaximumSize(new Dimension(100,20));
151.         /* Устанавливаем выравнивание по горизонтали (по центру) */
152.         button.setHorizontalAlignment(JButton.CENTER);
153.         /* Добавляем кнопку на панель */
154.         container.add(button);
155.         /* Возвращаем ссылку на кнопку */
156.         return button;
157.     }
158.     
159.     /* Метод расчета количества символов */
160.     public void calculate() throws Exception {
161. 		/* Записываем введенный текст из поля ввода в переменную */
162.     	String getText = fields[0].getText();
163. 		/* Рассчитываем длину введенного текста */
164.         String valueOf = String.valueOf(getText.length());
165. 		/* Записываем результат расчета в поле вывода */
166.         fields[1].setText(valueOf);
167.     }
168.     
169.     /* Метод расчета количества знаков препинания */
170.     public void calculatePunMarks() throws Exception {
171. 		/* Создаем переменную, в которой хранится
172. 		сумма всех точек и запятых.*/	
173.     	int valueOf = 0;
174. 		/* Записываем введенный текст из поля ввода в переменную */
175.     	String getText = fields[0].getText();
176. 		/* Рассчитываем количество точек и запятых с помощью цикла for */
177.     	for (int i = 0; i < getText.length(); i++) {
178. 			/* Используем условный оператор if
179. 			для увеличения значения переменной valueOf
180. 			каждый раз, когда во введенном наборе символов
181. 			встречается точка или запятая.*/
182.     		if ((getText.charAt(i) == ',') || (getText.charAt(i) == '.')) {
183.     			valueOf += 1;
184.     		}
185.     	}
186. 		/* Преобразовываем тип переменной valueOf
187. 		из целочисленного типа int в строковый тип String
188.         и записываем полученное значение в переменную result.*/		
189.     	String result = String.valueOf(valueOf);
190. 		/* Записываем результат расчета в поле вывода */
191.         fields[1].setText(result);
192.     }
193. 
194.     /* С помощью аннотации @Override указываем, что
195. 	метод, следующий за аннотацией, будет переопределен.*/
196.     @Override
197. 	/* Метод обработки события нажатия на кнопку */
198.     public void actionPerformed(ActionEvent e) {
199.         /* С помощью оператора if выполняем действие,
200. 		назначенное на ту кнопку, чье имя совпадаем со
201. 		строкой, которая передается в качестве параметра
202. 		встроенному методу equals.*/
203.         if (e.getActionCommand().equals("Расчет символов")) {
204. 			/* Обработка исключения на случай возникновения ошибок
205. 			в процессе выполнения кода, записанного в боке try.*/
206.             try {
207.                 /* Запускаем метод расчета количества символов */
208.                 calculate();
209. 			/* Код, выполняемый при возникновении ошибок
210. 			в процессе выполнения кода из блока try. */
211.             } catch (Exception ex) {
212.                 JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
213.             }
214.         } else if (e.getActionCommand().equals("Авторизация")) {
215.         	try {
216.                 /* Создаем объект класса CalcAuthorization */
217.                 CalcAuthorization calcAut = new CalcAuthorization();
218. 				/* Запускаем процесс авторизации */
219.                 calcAut.runAut();
220.             } catch (Exception ex) {
221.                 JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
222.             }
223.         } else if (e.getActionCommand().equals("Расчет точек и запятых")) {
224.         	try {
225. 				/* Если авторизация не пройдена - выводим предупреждающее
226. 				сообщение, в противном случае - запускаем метод расчета количества
227. 				точек и запятых. */
228.                 if(getStateId() == false) {
229.                 	JOptionPane.showMessageDialog(null, "Авторизируйтесь, чтобы получить доступ к этой функции");
230.                 } else {
231.                 	calculatePunMarks();
232.                 }
233.             } catch (Exception ex) {
234.                 JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
235.             }
236.         } else if (e.getActionCommand().equals("Сброс")) {
237.             /* Очищаем все поля через цикл */
238.             for(int i=0; i<fields.length; i++){
239.                 fields[i].setText("");
240.             }
241.         }
242.     }
243.     - bv
244.     /* Главный метод класса, запускающий калькулятор */
245.     public static void main(String[] args) {
246. 		/* С помощью метода invokeLater запускаем асинхронную операцию,
247. 		которая сохраняет действие (Runnable), и запускает его на одной
248. 		из следующих итераций цикла сообщений.*/
249.         SwingUtilities.invokeLater(new Runnable() {
250.             @Override
251. 			/* Создаем метод, который запускает калькулятор
252. 			через конструктор главного класса.*/
253.             public void run() {
254.                 new Calculator();
255.             }
256.         });
257.     }
258. }
