package com.capaub.msQuizz;

import com.capaub.msQuizz.model.CustomTimer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class MsQuizzApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsQuizzApplication.class, args);

		Timer chrono = new Timer();
		chrono.schedule(new CustomTimer(), 2000, 1000);
	}

}
