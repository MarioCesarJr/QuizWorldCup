package br.com.quiz.controller;

public class Quiz {
private int nivel=3;
private boolean flagSom=true;




public Quiz(int nivel, boolean flagSom) {
	super();
	this.nivel = nivel; 
	this.flagSom = flagSom;
}
public Quiz() {
	super();
	// TODO Auto-generated constructor stub
}
public int getNivel() {
	return nivel;
}
public void setNivel(int nivel) {
	this.nivel = nivel;
}
public boolean isFlagSom() {
	return flagSom;
}
public void setFlagSom(boolean flagSom) {
	this.flagSom = flagSom;
}
}
