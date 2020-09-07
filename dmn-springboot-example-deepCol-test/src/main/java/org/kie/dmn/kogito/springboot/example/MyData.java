package org.kie.dmn.kogito.springboot.example;

import java.util.Arrays;
import java.util.Collection;

public class MyData {
    
    private Collection<Collection<Person>> myCol;

    public MyData() {
        myCol = Arrays.asList(Arrays.asList(new Person("John", 29), new Person("Paul", 27)));
    }

	public Collection<Collection<Person>> getMyCol() {
		return myCol;
	}

	public void setMyCol(Collection<Collection<Person>> myCol) {
		this.myCol = myCol;
	}
}
