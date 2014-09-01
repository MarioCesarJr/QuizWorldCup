package br.com.quiz.controller;

public class Quiz {
private static int nivel=2;
private boolean flagSom=true;
private int index = 100; //usado no progressBar
private int minIndex = 0;//usado no progressBar
private int timerDelay = 200;    //usado no progressBar
private boolean stopTimer=false;


public boolean isStopTimer() {
	return stopTimer;
}
public void setStopTimer(boolean stopTimer) {
	this.stopTimer = stopTimer;
}
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public int getMinIndex() {
	return minIndex;
}
public void setMinIndex(int maxIndex) {
	this.minIndex = maxIndex;
}
public int getTimerDelay() {
	return timerDelay;
}
public void setTimerDelay(int timerDelay) {
	this.timerDelay = timerDelay;
}
@SuppressWarnings("static-access")
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
@SuppressWarnings("static-access")
public void setNivel(int nivel) {
	this.nivel = nivel;
}
public boolean isFlagSom() {
	return flagSom;
}
public void setFlagSom(boolean flagSom) {
	this.flagSom = flagSom;
}
public void reiniciaBar(){
	this.index = 100;
	this.minIndex = 0;
	this.timerDelay = 200;
}
}
