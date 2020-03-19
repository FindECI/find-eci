

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
<<<<<<< HEAD
*/ 
=======
 */
>>>>>>> e9ab2e66c8a487ce07f75b59f7d2458e8d25a483
package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
<<<<<<< HEAD
*/


=======
 */
>>>>>>> e9ab2e66c8a487ce07f75b59f7d2458e8d25a483
public interface UsuarioServices {
    
    //void saveUser(Usuario usuario) throws FindEciException;

<<<<<<< HEAD
    //Usuario findUserByEmail(String correo) throws FindEciException;
    
	
	boolean consultUser(String correo,String password) throws FindEciException;
}
=======
    Usuario findUserByCorreo(String correo) throws FindEciException;
    
}
>>>>>>> e9ab2e66c8a487ce07f75b59f7d2458e8d25a483
