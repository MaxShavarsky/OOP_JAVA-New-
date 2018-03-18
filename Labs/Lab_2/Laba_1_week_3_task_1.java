package com.tasks3.linkedlist;

public class LinkedList {
 private Node _head;
    private Node _tail;
    private int count=0;
  public LinkedList() {
 
  }

   public void add(Integer data){
        Node Spysok=new Node();
        Spysok.setData(data);
        if(_head==null){
            _head=Spysok;
            _tail=Spysok;
        }
        else{
            _tail.setNext(Spysok);
            _tail=Spysok;
        }
        count++;
    }
    public Integer get(int index) {
        Node Spysok = _head;
        if (index > count) {
            return null;
        } else {
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return Spysok.getData();
                }
                Spysok = Spysok.getNext();

            }
        }
        return null;
    }
    public int size(){
        return count;
    }
    public boolean delete(int index){
        Node useless=null;
        Node useless2=_head;
        if(index>count){
            return false;
        }
        else if(index==0){
           _head=_head.getNext();
           if(_head==null){
               _tail=null;
           }
           count--;
           return true;
        }
       else if(index==count-1){
            for(int i=0;i<=index;i++){
                if(i==index){
                    _tail=useless;
                    _tail.setNext(null);
                    count--;
                    return true;
                }
                useless=useless2;
                useless2=useless2.getNext();
            }
        }
        else{
            for(int i=0;i<=index;i++){
                if(i==index){
                    useless.setNext(useless2.getNext());
                    count--;
                    return true;
                }
                useless=useless2;
                useless2=useless2.getNext();
            }
        }
        return false;
    }
    }
