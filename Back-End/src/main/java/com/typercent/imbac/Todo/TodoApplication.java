package com.typercent.imbac.Todo;

import com.typercent.imbac.Todo.entity.Todo;
import com.typercent.imbac.Todo.repository.TodoRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

//	@Bean
//	ApplicationRunner init(TodoRepo todoRepo) {
//		return args -> {
//			LocalDateTime ctd = LocalDateTime.of(2021, 1, 14, 11, 43, 12);
//			LocalDateTime ctd2 = LocalDateTime.of(2021, 1, 19, 11, 43, 12);
//			LocalDateTime ctd3 = LocalDateTime.of(2021, 1, 10, 11, 43, 12);
//			LocalDateTime ctd4 = LocalDateTime.of(2021, 1, 4, 11, 43, 12);
//
//			Todo toDo1 = new Todo();
//			toDo1.setTitle("Hello World!");
//			toDo1.setCreatedDate(ctd);
//			todoRepo.save(toDo1);
//
//			Todo toDo2 = new Todo();
//			toDo2.setTitle("I'm bac u know me, huh");
//			toDo2.setCreatedDate(ctd2);
//			todoRepo.save(toDo2);
//
//			Todo toDo3 = new Todo();
//			toDo3.setTitle("do a kickflip");
//			toDo3.setCreatedDate(ctd3);
//			todoRepo.save(toDo3);
//
//			Todo toDo4 = new Todo();
//			toDo4.setTitle("do a heelflip");
//			toDo4.setCreatedDate(ctd4);
//			todoRepo.save(toDo4);
//		};
//	}
}
