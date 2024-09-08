package com.example.basic_demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY) // bir kullanıcının birden fazla gönderisi olabilir
	@JoinColumn(name = "user_id",nullable = false) // bağlanacağı kolon
	@OnDelete(action = OnDeleteAction.CASCADE) // kullanıcı silindiğinde gönderiler de silinsin
	@JsonIgnore // bu alanı görmezden gel
	User user;
	
	String title;
	@Lob
	@Column(columnDefinition = "text") // string text olarak alsın varchar olarak almasın
	String text;
}
