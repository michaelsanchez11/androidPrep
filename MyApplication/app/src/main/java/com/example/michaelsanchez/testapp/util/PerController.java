package com.example.michaelsanchez.testapp.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by michaelsanchez on 3/25/17.
 */

//Only initialize this class at runtime
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerController {

}
