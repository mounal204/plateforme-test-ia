package com.example.demo.entity;

import java.time.LocalDateTime;

public class Tentative {
	 private Long id;

	    private double score;

	    private LocalDateTime date;

		public Long getId() {
			return id;
		}

		public void setScore(double score) {
			this.score = score;
		}
		public double getScore() {
			return score;
		}

		public void setId(Long id) {
			this.id = id;
		}
		

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

}
