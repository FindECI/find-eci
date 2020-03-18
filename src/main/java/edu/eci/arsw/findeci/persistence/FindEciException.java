/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

/**
 *
 * @author andres.quintero-d
 */
public class FindEciException extends Exception{
    
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ALREDY_EXISTS = "User  already exists";

    
    public FindEciException(){
        super();
    }

    public FindEciException(String msg){
        super(msg);
    }
}
