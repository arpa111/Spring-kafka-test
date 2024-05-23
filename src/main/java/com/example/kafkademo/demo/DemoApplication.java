package com.example.kafkademo.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;

import java.io.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		//System.out.println("demo1");
	}

		@Bean
		CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate)
		{
			return args ->
			{

				BufferedReader br = new BufferedReader(new FileReader("C:\\file\\myfile.txt"));
				String line = br.readLine();
				/*while (line != null){
					kafkaTemplate.send("test", br.readLine());
					//kafkaTemplate.receive("test",0)
					System.out.println(line);
					line = br.readLine();
				}*/
				for (int i = 1 ; i<= 1000 ;i++)
				{
					kafkaTemplate.send("test",String.valueOf(i));
				}
				br.close();
			};
		}


}
