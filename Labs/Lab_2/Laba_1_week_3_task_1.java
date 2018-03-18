package com.tasks3.linkedlist;

public class LinkedList {
	private Node golova;
	private Node hvist;
	private int count = 0;
	public LinkedList() {

	}

	public void add(Integer data) {
		Node Spysok = new Node();
		Spysok.setData(data);
		if (golova == null) {
			golova = Spysok;
			hvist = Spysok;
		}
		else {
			hvist.setNext(Spysok);
			hvist = Spysok;
		}
		count++;
	}
	public Integer get(int index) {
		Node Spysok = golova;
		if (index > count) {
			return null;
		}
		else {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					return Spysok.getData();
				}
				Spysok = Spysok.getNext();

			}
		}
		return null;
	}
	public int size() {
		return count;
	}
	public boolean delete(int index) {
		Node mysor = null;
		Node mysor2 = golova;
		if (index>count) {
			return false;
		}
		else if (index == 0) {
			golova = golova.getNext();
			if (golova == null) {
				hvist = null;
			}
			count--;
			return true;
		}
		else if (index == count - 1) {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					hvist = mysor;
					hvist.setNext(null);
					count--;
					return true;
				}
				mysor = mysor2;
				mysor2 = mysor2.getNext();
			}
		}
		else {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					mysor.setNext(mysor2.getNext());
					count--;
					return true;
				}
				mysor = mysor2;
				mysor2 = mysor2.getNext();
			}
		}
		return false;
	}
}
