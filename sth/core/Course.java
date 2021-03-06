package sth.core;

import sth.core.exception.BadEntryException;
import java.util.*;
import sth.core.exception.NumberOfDelegatesExceed;

public class Course implements java.io.Serializable {
	private String _name;
	private int _numberOfRepresentatives;
	private HashMap<String, Discipline> _disciplineMap;
	private HashMap<Integer, Student> _studentMap;

	public Course(String name){
		_numberOfRepresentatives = 0;
		_name = name;
		_disciplineMap = new HashMap<>();
		_studentMap = new HashMap<>();
	}

	public String getName(){
		return _name;
	}
	
	Discipline getDiscipline(String name) {
		return _disciplineMap.get(name);
	}
	
	Student getStudent(String name) {
		for(Student s : _studentMap.values()) {
			if(s.getName().equals(name))
				return s;
		}
		return null;
	}
	
	
	HashMap<String, Discipline> getDisciplineMap(){
		return _disciplineMap;
	}

	void addDiscipline(Discipline discipline) throws BadEntryException{
		if(_disciplineMap.containsKey(discipline.getName()))
			throw new BadEntryException("Discipline already exists");
		_disciplineMap.put(discipline.getName(), discipline);
	}
	
	void addStudent(Student student) throws BadEntryException {
		if(_studentMap.containsKey(student.getId()))
			throw new BadEntryException("Student already exists");
		_studentMap.put(student.getId(), student);
	}
	
	void addRepresentative(Student student) throws NumberOfDelegatesExceed, BadEntryException{
		if(_numberOfRepresentatives > 7)
			throw new NumberOfDelegatesExceed(_name);
		if(!_studentMap.containsKey(student.getId()))
			throw new BadEntryException("Student out of course");
		student.setRepresentative(true);
		_numberOfRepresentatives ++;
	}

	Discipline parseDiscipline(String name) {
    	if (_disciplineMap.get(name) == null) {
        	Discipline discipline = new Discipline(name, this);
        	_disciplineMap.put(name, discipline);
        	return discipline;
    	}
    	return _disciplineMap.get(name);
    }
	
	
	public List<Discipline> getSortedDisciplineList() {
		
		List<Discipline> listDiscipline = new ArrayList<>(_disciplineMap.values());
		
		Collections.sort(listDiscipline, Comparator.comparing(Discipline::getName));
		
		return listDiscipline;
	}
}