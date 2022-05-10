package com.example.cpsc411petownerapp

//abstract Person class with age, address, sex, name, phoneNumber
abstract class Person(val age: Int, val address: String, val sex: String, val name: String, val phoneNumber: String
                      , val petType: String,val petAge: Int, val petName: String){
    abstract fun output() //abstract method
}

//AnyPet class with variables type, name, age
abstract class AnyPet(val type:String, val name: String, val age:Int){
    abstract fun output() //abstract method
}

//User has variables age, address, sex, name, phoneNumber and initializes pet and inherits
//the abstract class Person
class User(age: Int, address: String, sex: String, name: String, phoneNumber: String,petType: String,
           petAge: Int, petName: String, var pet: Pet = Pet(type="",name="",age=0)):
    Person(age,address,sex,name,phoneNumber, petType, petAge, petName){
    override fun output() {
        println("Age is $age")
        println("Address is $address")
        println("Sex is $sex")
        println("Name is $name")
        println("Phone number is $phoneNumber")
        println("Pet type is $petType")
        println("Pet age is $petAge")
        println("Pet name is $petName")
    }
}

//Pet has variables type, name, age and inherits the abstract class AnyPet
class Pet(type:String,name:String,age:Int):AnyPet(type, name, age){
    override fun output() {
        println("Type is $type")
        println("Name is $name")
        println("Age is $age")
    }
}
