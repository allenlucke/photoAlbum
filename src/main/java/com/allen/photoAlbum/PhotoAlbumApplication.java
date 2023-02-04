package com.allen.photoAlbum;

import com.allen.photoAlbum.Logic.PhotoAlbumLogic;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class PhotoAlbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoAlbumLogic photoAlbumLogic;

	@Override
	public void run(String... args) throws Exception {

		Option help = Option.builder("h").required(false).hasArg(false).longOpt("help").build();

		Option albumId = Option.builder("a").required(false).hasArg(true).argName("Album Id").longOpt("albumId").build();

		Options options = new Options();
		options.addOption(help);
		options.addOption(albumId);

		CommandLineParser parser = new DefaultParser();
		CommandLine line = parser.parse(options, args);

		if(line.hasOption("h")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java -jar springboot-apache-cli.jar", options, true);
			return;
		}

		this.photoAlbumLogic.printPhotos(line.getOptionValue("a"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PhotoAlbumApplication.class, args);
	}

}
