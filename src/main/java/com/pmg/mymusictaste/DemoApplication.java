package com.pmg.mymusictaste;

import com.pmg.mymusictaste.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Setter;

@SpringBootApplication
public class DemoApplication {

	@Setter(onMethod_ = { @Autowired })
    private static SongService sServ;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
