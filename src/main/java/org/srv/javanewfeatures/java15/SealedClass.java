package org.srv.javanewfeatures.java15;

import lombok.NonNull;

//the goal of sealed classes is to allow individual classes to declare which types may be used as sub-types.
// This also applies to interfaces and determining which types can implement them.
//Sealed classes involve two new keywords — sealed and permits:

public sealed interface SealedClass permits SampleImplementation {

  @NonNull
  String dataSet = "MORGAN_DATA_CENTER";

}


