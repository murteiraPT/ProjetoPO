package sth.core;

import sth.core.exception.BadEntryException;

import java.io.IOException;
import java.util.*;

/**
 * School implementation.
 */
public class School implements java.io.Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201810051538L;

    private String _name;
    private static int _nextPersonID;

    private HashMap<String, Course> _courseMap ;
    private HashMap<Integer, Person> _personMap ;

    /**
    * @param filename
    * @throws BadEntryException
    * @throws IOException
    */

    void importFile(String filename) throws IOException, BadEntryException {
    	Parser p = new Parser(this);
    	p.parseFile(filename);
    }


    public School(String name){
        _name = name;
        _nextPersonID = 100000;
        _courseMap = new HashMap<>();
        _personMap = new HashMap<>();
    }

    Person getPerson (int id){
        return _personMap.get(id);
    }
    
    Course getCourse(String name) {
    	return _courseMap.get(name);
    }

    void addPerson(Person person) throws BadEntryException{
        if (_personMap.containsKey(person.getId()))
        	throw new BadEntryException("Person already exists");
            _nextPersonID++;
            _personMap.put(_nextPersonID, person);
    }

    void addCourse(Course course) throws BadEntryException{
        if (_courseMap.containsKey(course.getName()))
            throw new BadEntryException("Course already exists");
            _courseMap.put(course.getName(), course);
    }

    HashMap<Integer, Person> getAllUsers(){
        return _personMap;
    }

    int getNumberOfPersons(){
        return _nextPersonID;
    }
    
    HashMap<String, Course> getCourseMap(){
    	return _courseMap;
    }
    
    Course parseCourse(String name) {
    	if(_courseMap.get(name) == null) {
    		Course course = new Course(name);
        	_courseMap.put(name, course);
        	return course;
    	}
    	return _courseMap.get(name);
    }
}
