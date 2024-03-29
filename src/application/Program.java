package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> lessonList = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		System.out.println();		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Dados da %da aula:\n", i);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if(ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				Integer duration = sc.nextInt();				
				lessonList.add(new Video(title, url, duration));
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				Integer numberQuestions = sc.nextInt();
				lessonList.add(new Task(title, description, numberQuestions));
			}
			System.out.println();
		}
		
		int totalDurationOfTheCourses = 0;
		for(Lesson list : lessonList) {
			totalDurationOfTheCourses += list.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", totalDurationOfTheCourses);
		
		sc.close();
	}
}
