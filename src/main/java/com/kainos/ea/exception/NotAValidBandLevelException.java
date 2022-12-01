package com.kainos.ea.exception;

public class NotAValidBandLevelException extends Throwable{
   public NotAValidBandLevelException(String message , Exception e){
       super(message, e);
   }

}
