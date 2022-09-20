/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.examendos;

/**
 *
 * @author AbimelecG2
 */
public class Main {
 static conexionDB conexMongo;
 
    public static void main(String[]args){
        
        conexMongo= new conexionDB();
        conexMongo.setDB();
        
        Maquinaria h = new Maquinaria();
        h.setVisible(true);
    }   
}
