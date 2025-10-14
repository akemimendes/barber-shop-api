package com.barbershop.barbershop.exception;

public class NaoEncontradoExcecao extends RuntimeException{

    public NaoEncontradoExcecao(String mensagem){
        super(mensagem);
    }

}