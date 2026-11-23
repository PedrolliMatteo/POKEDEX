package org.example;

public class Pokemon
{
    public int index;
    public String nome;
    public String tipo1;
    public String tipo2;
    public int HP;
    public String abilita;

    public Pokemon(String tipo1, String tipo2, int HP, String abilita, String nome, int index)
    {
        this.index = index;
        this.nome = nome;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.HP = HP;
        this.abilita = abilita;
    }


}
