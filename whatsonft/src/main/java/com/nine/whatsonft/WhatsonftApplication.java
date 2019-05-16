package com.nine.whatsonft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * WhatsOnFT merupakan suatu website yang berfungsi untuk listing event. User dapat melakukan konfirmasi kehadiran melalui web ini.
 * Class ini merupakan main class yang hanya berfungsi untuk menjalankan SpringApplication.
 *
 * @author Akmal Ramadhan Arifin, Senna Faris Wibowo, Muhammad Adhie Nugroho, Hasnan Fiqih
 * @version 16-05-2019
 */
@SpringBootApplication
public class WhatsonftApplication {
    /**
     * Method main untuk menjalankan SpringApplication
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(WhatsonftApplication.class, args);
	}

}
