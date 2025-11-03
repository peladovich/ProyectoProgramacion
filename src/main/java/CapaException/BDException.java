/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaException;

public class BDException extends Exception {
    public BDException(String mensaje) { super(mensaje); }
    public BDException(String mensaje, Throwable causa) { super(mensaje, causa); }
}
