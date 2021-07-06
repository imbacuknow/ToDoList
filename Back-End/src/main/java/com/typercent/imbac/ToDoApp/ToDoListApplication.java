package com.typercent.imbac.ToDoApp;

import com.typercent.imbac.ToDoApp.entity.ToDo;
import com.typercent.imbac.ToDoApp.repository.ToDoRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ToDoRepo toDoRepo) {
		return args -> {
			LocalDateTime ctd = LocalDateTime.of(2021, 1, 14, 11, 43, 12);
			LocalDateTime ctd2 = LocalDateTime.of(2021, 1, 19, 11, 43, 12);
			LocalDateTime ctd3 = LocalDateTime.of(2021, 1, 10, 11, 43, 12);
			LocalDateTime ctd4 = LocalDateTime.of(2021, 1, 4, 11, 43, 12);

			ToDo toDo1 = new ToDo();
			toDo1.setTitle("Hello World!");
			toDo1.setCreatedDate(ctd);
			toDoRepo.save(toDo1);

			ToDo toDo2 = new ToDo();
			toDo2.setTitle("I'm bac u know me, huh");
			toDo2.setCreatedDate(ctd2);
			toDoRepo.save(toDo2);

			ToDo toDo3 = new ToDo();
			toDo3.setTitle("do a kickflip");
			toDo3.setCreatedDate(ctd3);
			toDoRepo.save(toDo3);

			ToDo toDo4 = new ToDo();
			toDo4.setTitle("do a heelflip");
			toDo4.setCreatedDate(ctd4);
			toDoRepo.save(toDo4);
		};
	}
}
