package com.questions.java.oops;

import java.util.List;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * Composition in java is the design technique to implement has-a relationship in classes. We can use java inheritance or Object composition in java for code reuse.
 *
 * Examples :
 * 1) A “university” has several “departments”. Without existence of “university” there is no chance for the “departments” to exist.
 * Hence “university” and “departments” are strongly associated and this strong association is known     as composition.
 * 2) Person has a Brain.
 * 3) Person has a Heart.
 *
 *
 * Composition is a special case of aggregation. In a more specific manner, a restricted aggregation is called composition. When an object contains the other object, if the contained object cannot exist without the existence of container object, then it is called composition. Example: A class contains students. A student cannot exist without a class. There exists composition between class and students.
 */
public class CompositionClass {
}

class Department{
    String name;
}

class University{
    List<Department> departments;
}
