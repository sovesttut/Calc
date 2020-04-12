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
21. который отвечает за обработку события нажатия на кнопку.
22. */
23. public class CalcAuthorization implements ActionListener{
24. 	
25. 	/* Создаем объект окна авторизации с помощью ключевого слова new */
26.     JFrame frameAut = new JFrame("Авторизация");
27. 	/* Создаем объект панели с метками */
28.     JPanel panelLeftAut = new JPanel();
29. 	/* Создаем объект панели с текстовыми полями */
30.     JPanel panelRightAut = new JPanel();
31. 	/* Создаем объект панели с кнопками */
32.     JPanel panelBottomAut = new JPanel();
33. 	/* Создаем массив текстовых полей */
34.     public JTextField[] fieldsAut = new JTextField[2];
35. 
36.      /* Добавляем конструктор класса */
37.     public CalcAuthorization() {
38.         /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
39.         panelLeftAut.setLayout(new BoxLayout(panelLeftAut, BoxLayout.Y_AXIS));
40.         /* Устанавливаем размер панели с метками 250 на 300 пикселей */
41.         panelLeftAut.setPreferredSize(new Dimension(250, 300));
42. 
43.         /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
44.         panelRightAut.setLayout(new BoxLayout(panelRightAut, BoxLayout.Y_AXIS));
45.         /* Устанавливаем  размер 230 на 300 пикселей */
46.         panelRightAut.setPreferredSize(new Dimension(230,300));
47. 
48.         /* Добавляем метки к текстовым полям через метод addLabel */
49.         addLabel(panelLeftAut, "Логин:", Color.BLACK);
50.         addLabel(panelLeftAut, "Пароль:", Color.BLACK);
51.         /* Добавляем текстовые поля через цикл и записываем их в массив */
52.         for(int i = 0; i < fieldsAut.length; i++){
53.             if(fieldsAut.length >= 0){
54.                 /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
55.                 fieldsAut[i] = addTextField(panelRightAut);}
56.         }
57. 
58.         /* Добавляем кнопку подтверждения авторизации */
59.         JButton signInAut = addButton(panelBottomAut, "Авторизоваться");
60.         /* Добавляем слушатель на событие нажатия */
61.         signInAut.addActionListener(this);
62. 		/* Добавляем кнопку сброса */
63.         JButton resetAut = addButton(panelBottomAut, "Сброс");
64.         /* Добавляем слушатель на событие нажатия */
65.         resetAut.addActionListener(this);
66. 
67.         /* Делаем окно авторизации видимым */
68.         frameAut.setVisible(true);
69.         /* Устанавливаем действие при нажатии на крестик - завершение приложения */
70.         frameAut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
71.         /* Устанавливаем начальное положение окна авторизации относительно центра экрана (по центру) */
72.         frameAut.setLocationRelativeTo(null);
73.         /* Устанавливаем размер окна авторизации (450 на 200) */
74.         frameAut.setSize(450,200);
75. 
76.         /* Добавляем панель с метками на окно авторизации */
77.         frameAut.add(panelLeftAut, BorderLayout.WEST);
78. 		/* Добавляем панель с текстовыми полями на окно авторизации */
79.         frameAut.add(panelRightAut, BorderLayout.EAST);
80. 		/* Добавляем панель с кнопками на окно авторизации */
81.         frameAut.add(panelBottomAut, BorderLayout.SOUTH);
82. 		/* Запрещаем изменение размеров окна авторизации */
83.         frameAut.setResizable(false);
84.     }
85. 
86.     /* Метод добавления текстовых меток */
87.     public void addLabel(JComponent container, String name, Color color){
88.         /* Создаем объект текстовой метки */
89.         JLabel label = new JLabel(name);
90.         /* Устанавливаем максимально допустимый размер метки */
91.         label.setMaximumSize(new Dimension(200,20));
92.         /* Устанавливаем цвета текста метки */
93.         label.setForeground(color);
94.         /* Устанавливаем выравнивание метки по правому краю */
95.         label.setHorizontalAlignment(JLabel.RIGHT);
96.         /* Добавляем рамку вокруг метки */
97.         label.setBorder(new EtchedBorder());
98.         /* Добавляем метку на панель */
99.         container.add(label);
100.     }
101. 
102.     /* Метод добавления текстовых полей */
103.     public JTextField addTextField(JComponent container){
104.         /* Создаем объект текстового поля */
105.         JTextField field = new JTextField();
106.         /* Устанавливаем максимально допустимый размер поля */
107.         field.setMaximumSize(new Dimension(350,20));
108.         /* Добавляем поле на панель */
109.         container.add(field);
110.         /* Возвращаем ссылку на текстовое поле */
111.         return field;
112.     }
113. 
114.     /* Метод добавления кнопок */
115.     public JButton addButton(JComponent container, String name){
116.         /* Создаем объект кнопки */
117.         JButton button = new JButton(name);
118.         /* Устанавливаем максимально допустимый размер кнопки */
119.         button.setMaximumSize(new Dimension(100,20));
120.         /* Устанавливаем выравнивание по горизонтали (по центру) */
121.         button.setHorizontalAlignment(JButton.CENTER);
122.         /* Добавляем кнопку на панель */
123.         container.add(button);
124.         /* Возвращаем ссылку на кнопку */
125.         return button;
126.     }
127.     
128.     /* Метод прохождения авторизации */
129.     public void signIn() throws Exception {
130. 		/* Записываем введенный текст из поля ввода логина в переменную */
131.     	String login = fieldsAut[0].getText();
132. 		/* Записываем введенный текст из поля ввода пароля в переменную */
133.     	String password = fieldsAut[1].getText();
134. 		/* Создаем массив, который содержит допустимые значения логина */
135.     	String[] loginArray = {"Ard", "Bay", "Shay", "Step"};
136. 		/* Создаем массив, который содержит допустимые значения пароля */
137.     	String[] passwordArray = {"17130470", "17130175", "17130180", "17130705"};
138.     	
139. 		/* Выполняем проверку введенных логина и пароля через цикл for.
140. 		Если введенные значения совпадают со значениями в массивах,
141. 		проверка пройдена успешно и авторизация выполнена.
142. 		*/
143.     	for (int i = 0; i < loginArray.length; i++) {
144.     		if ((login.equals(loginArray[i])) && (password.equals(passwordArray[i]))) {
145. 				/* Создаем объект главного класса Calculator */
146.         		Calculator calc = new Calculator();
147. 				/* Изменяем значение переменной id в главном классе */
148.         		calc.setStateId(true);
149. 				/* Выводим сообщение об успешном прохождении процесса авторизации */
150.         		JOptionPane.showMessageDialog(null, "Авторизация пройдена успешно");
151. 				/* Скрываем окно авторизации */
152.         		frameAut.setVisible(false);
153.         	}
154.     	}
155.     }
156.     
157.     /* С помощью аннотации @Override указываем, что
158. 	метод, следующий за аннотацией, будет переопределен.
159. 	*/	
160.     @Override
161. 	/* Метод обработки события нажатия на кнопку */
162.     public void actionPerformed(ActionEvent e) {
163.         /* С помощью оператора if выполняем действие,
164. 		назначенное на ту кнопку, чье имя совпадаем со
165. 		строкой, которая передается в качестве параметра
166. 		встроенному методу equals.
167. 		*/
168.         if (e.getActionCommand().equals("Авторизоваться")) {
169. 			/* Обработка исключения на случай возникновения ошибок
170. 			в процессе выполнения кода, записанного в боке try.
171. 			*/
172.             try {
173.                 /* Запускаем метод авторизации */
174.             	signIn();
175. 			/* Код, выполняемый при возникновении ошибок
176. 			в процессе выполнения кода из блока try.
177. 			*/
178.             } catch (Exception ex) {
179.                 JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
180.             }
181.         } else if (e.getActionCommand().equals("Сброс")) {
182.             /* Очищаем все поля через цикл */
183.             for(int i=0; i<fieldsAut.length; i++){
184.                 fieldsAut[i].setText("");
185.             }
186.         }
187.     }
188.     
189.     /* Главный метод класса, запускающий процесс авторизации */
190.     public void runAut() {
191. 		/* С помощью метода invokeLater запускаем асинхронную операцию,
192. 		которая сохраняет действие (Runnable), и запускает его на одной
193. 		из следующих итераций цикла сообщений.
194. 		*/
195.         SwingUtilities.invokeLater(new Runnable() {
196.             @Override
197. 			/* Создаем метод, который запускает процесс авторизации
198. 			через конструктор класса.
199. 			*/
200.             public void run() {
201.                 new CalcAuthorization();
202.             }
203.         });
204.     }
205. }
