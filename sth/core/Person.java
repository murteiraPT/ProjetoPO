package sth.core;

public class abstract Person{

	private int _id;
	private String _name;
	private int _phoneNumber;

	public Person(int numberOfPersons, String name, int phone)
	{
		_id=100000 + numberOfPersons;
		_name=name;
		_phoneNumber=phone;
	}

	public String getName(){
		return _name;
	}

	public int getId(){
		return _id;
	}


	@Override
	public String toString(){
		return toString(_id) + '|' + toString(_phoneNumber) + '|' + _name
	}

	public void setPhone(int phone){
		_phoneNumber=phone;
	}

	public void getPhone(){
		return _phoneNumber;
	}

}


	