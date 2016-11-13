/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

/**
 *
 * @author Innocent
 */

public class InvalidTokenException extends Exception{

    public InvalidTokenException (String message, Throwable cause){
        super(message,cause);
    }

}

