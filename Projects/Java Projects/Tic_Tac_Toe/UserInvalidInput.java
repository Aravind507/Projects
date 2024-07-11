package Tic_Tac_Toe;

public class UserInvalidInput extends Exception{
    private String name;
    public UserInvalidInput(){}
    public UserInvalidInput(String name){this.name = name;}
}
